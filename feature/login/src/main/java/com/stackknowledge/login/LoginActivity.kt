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
    private var isTeacher = false

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
                googleLogin = { googleSignIn() },
                isStudent = { isStudentState.value = it },
                // isTeacher = { isTeacher = it }
            )
        }
        Log.d("roleCheck", isStudent.toString())
        viewModel.roleCheck(role = isStudent)

        Log.d("LoginActivity", "Intent data: ${intent.data}")
        intentData(intent.data, isStudent)
    }

    private fun googleSignIn() {
        val url =
            "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?ei5r49r2ou9pflsn9bas5hvj4c13uroq.apps.googleusercontent.com&response_type=code&redirect_uri=${BuildConfig.REDIRECT_URI}&scope=${BuildConfig.SCOPE}&client_id=${BuildConfig.GOOGLE_CLIENT_ID}&prompt=select_account"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun intentData(
        uri: Uri?,
        isStudent: Boolean,
    ) {
        val code = uri?.getQueryParameter("code")
        Log.d("LoginActivity", "Extracted code: $code")
        if (!code.isNullOrBlank()) {
            Log.d("isStudent", isStudent.toString())
            when (isStudent) {
                true -> viewModel.loginStudent(body = LoginRequest(code))
                false -> viewModel.loginTeacher(body = LoginRequest(code))
            }
        } else {
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }
    }
}
