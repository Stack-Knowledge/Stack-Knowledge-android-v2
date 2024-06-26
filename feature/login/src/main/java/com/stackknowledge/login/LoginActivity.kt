package com.stackknowledge.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.viewmodel.AuthViewModel
import com.stackknowledge.login.viewmodel.util.Event
import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()
    private var isStudent = false
    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }
    private val googleAuthLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

        try {
            val account = task.getResult(ApiException::class.java)
            Log.e("try launch", account.toString())
            account.serverAuthCode?.let { viewModel.loginStudent(LoginRequest(it)) } // 서버에 idToken 보내기
        } catch (e: ApiException) {
            Log.e(LoginActivity::class.java.simpleName, e.stackTraceToString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent?.let {
            isStudent = it.getBooleanExtra("isStudent", false)
            viewModel.roleCheck(isStudent)
            Log.d("LoginActivity", "Intent extra isStudent: $isStudent")
        }

        setContent {
            val isStudentState = rememberSaveable { mutableStateOf(false) }

            LoginRoute(
                viewModel = viewModel,
                googleLogin = {
                    googleSignIn(
                        isStudent = isStudent
                    )
                },
                isStudent = { isStudentState.value = it },
                // isTeacher = { isTeacher = it }
            )
        }
        Log.d("roleCheck", isStudent.toString())
        viewModel.roleCheck(role = isStudent)

        Log.d("LoginActivity", "Intent data: ${intent.data}")
//        intentData(intent.data, isStudent)
    }

    private fun googleSignIn(
        isStudent: Boolean
    ) {
        googleSignInClient.signOut()
        val signInIntent = googleSignInClient.signInIntent
        googleAuthLauncher.launch(signInIntent)
        if (isStudent) {
            intentData(intent.data, isStudent)
        }
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(BuildConfig.GOOGLE_CLIENT_ID)
            .build()

        return GoogleSignIn.getClient(this, googleSignInOption)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("LoginActivity", "onNewIntent called")
        intent.data?.let {
            intentData(it, isStudent)
        }
    }

    private fun intentData(
        uri: Uri?,
        isStudent: Boolean,
    ) {
        val code = uri?.getQueryParameter("code")
        Log.d("LoginActivity", "Extracted code: $code")
        if (!code.isNullOrBlank()) {
            if(isStudent) {
                viewModel.loginStudent(body = LoginRequest(code))
            } else {
                viewModel.loginTeacher(body = LoginRequest(code))
            }
        } else {
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }
    }
}
