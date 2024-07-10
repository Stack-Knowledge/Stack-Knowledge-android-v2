package com.stackknowledge.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import remote.request.auth.LoginRequest
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    @Inject
    @Named("GOOGLE_CLIENT_ID")
    lateinit var googleClientId: String

    @Inject
    @Named("SCOPE")
    lateinit var scope: String

    private val viewModel by viewModels<AuthViewModel>()
//    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }
//
//    private val googleSignInLauncher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//            handleGoogleSignInResult(task)
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            StackKnowledgeAndroidTheme { _, _ ->
//                //임의로 LoginFlow 설정 이거 수정해야함
//                RoleCheckRoute(
//                    onTeacherButtonClick = { isTeacher ->
//                        viewModel.showLoginRoute.value = true
//                        viewModel.isTeacher.value = isTeacher
//                    },
//                    onStudentButtonClick = { isStudent ->
//                        viewModel.showLoginRoute.value = true
//                        viewModel.isStudent.value = isStudent
//                    }
//                )
//                if (viewModel.showLoginRoute.value) {
//                    LoginRoute(
//                        onGoogleLoginButtonClicked = {
//                            googleSocialLogin()
//                        }
//                    )
//                }
//            }
//        }
    }

//    private fun googleSocialLogin() {
//        googleSignInClient.signOut().addOnCompleteListener {
//            val signInIntent = googleSignInClient.signInIntent
//            googleSignInLauncher.launch(signInIntent)
//        }
//    }

//    private fun getGoogleClient(): GoogleSignInClient {
//        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestScopes(Scope(scope))
//            .requestServerAuthCode(googleClientId)
//            .requestIdToken(googleClientId)
//            .requestEmail()
//            .build()
//
//        return GoogleSignIn.getClient(this@LoginActivity, googleSignInOptions)
//    }
//
//    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
//        Log.e("handleGoogleSignInResult", "${task.result}")
//        try {
//            val account = task.getResult(ApiException::class.java)
//            account?.idToken?.let { idToken ->
//                if (viewModel.isStudent.value) {
//                    viewModel.loginStudent(body = LoginRequest(code = idToken))
//                } else {
//                    viewModel.loginTeacher(body = LoginRequest(code = idToken))
//                }
//                moveToMainActivity()
//            }
//        } catch (e: ApiException) {
//            Log.e("LoginActivity", "Google sign-in failed: ${e.statusCode}")
//        }
//    }
//
//    private fun moveToMainActivity() {
//        val intent = Intent().setClassName(this, "com.stackknowledge.MainActivity")
//        startActivity(intent)
//        finish()
//    }
}