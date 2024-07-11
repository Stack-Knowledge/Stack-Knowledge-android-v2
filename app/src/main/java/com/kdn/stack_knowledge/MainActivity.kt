package com.kdn.stack_knowledge

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.viewmodel.AuthViewModel
import com.kdn.stack_knowledge.ui.StackKnowledgeApp
import com.stackknowledge.user.R
import dagger.hilt.android.AndroidEntryPoint
import remote.request.auth.LoginRequestModel
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("GOOGLE_CLIENT_ID")
    lateinit var googleClientId: String

    @Inject
    @Named("SCOPE")
    lateinit var scope: String

    private val viewModel by viewModels<AuthViewModel>()

    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }

    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleGoogleSignInResult(task)
        }

    private var doubleBackToExitPressedOnce = false

    private var backPressedTimestamp = 0L

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            controlTheStackWhenBackPressed()
        }
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        setContent {
            CompositionLocalProvider(LocalViewModelStoreOwner provides this) {
                StackKnowledgeAndroidTheme { _, _ ->
                    StackKnowledgeApp(
                        windowSizeClass = calculateWindowSizeClass(this@MainActivity),
                        onLoginButtonClick = {
                            googleSocialLogin()
                        }
                    )
                }
            }
        }
    }

    private fun controlTheStackWhenBackPressed() {
        val currentTime = System.currentTimeMillis()
        if (doubleBackToExitPressedOnce && currentTime - backPressedTimestamp <= 2000) {
            finishAffinity()
        } else {
            doubleBackToExitPressedOnce = true
            backPressedTimestamp = currentTime
            Toast.makeText(this, getString(R.string.close_app), Toast.LENGTH_SHORT).show()
        }
    }

    private fun googleSocialLogin() {
        googleSignInClient.signOut().addOnCompleteListener {
            val signInIntent = googleSignInClient.signInIntent
            googleSignInLauncher.launch(signInIntent)
        }
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope(scope))
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(this@MainActivity, googleSignInOptions)
    }

    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        val account = task.getResult(ApiException::class.java)

        with(viewModel) {
            if (isStudent.value) {
                loginStudent(body = LoginRequestModel(code = account.serverAuthCode.toString()))
            } else {
                loginTeacher(body = LoginRequestModel(code = account.serverAuthCode.toString()))
            }
        }
    }
}