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
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.viewmodel.AuthViewModel

class LoginActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intentData(intent.data)

        setContent {
            LoginScreen(
                googleLogin = { googleSignIn() }
            )
        }
    }

    private fun googleSignIn() {
        //val url = "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?ei5r49r2ou9pflsn9bas5hvj4c13uroq.apps.googleusercontent.com&response_type=code&redirect_uri=http://localhost:3001/auth/login&scope=https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email&client_id=853689307201-a3q5ep5c2ld77rqblsg3svk78i7sr2oa.apps.googleusercontent.com"
        val url = "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?ei5r49r2ou9pflsn9bas5hvj4c13uroq.apps.googleusercontent.com&response_type=code&redirect_uri=${BuildConfig.REDIRECT_URI}&scope=${BuildConfig.FIRST_SCOPE}&client_id=${BuildConfig.GOOGLE_CLIENT_ID}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
        Log.d("google_login",url)
    }

    private fun intentData(uri: Uri?) {
        uri?.let {
            val code = it.getQueryParameter("code")
            if (!code.isNullOrBlank()) {
                viewModel.requestAuthCode(code)
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
