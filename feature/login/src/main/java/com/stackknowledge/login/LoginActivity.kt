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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.navigation.roleCheckRoute
import com.stackknowledge.login.viewmodel.AuthViewModel
import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen(
                googleLogin = { googleSignIn() }
            )
        }

        intentData(intent.data)
    }

    private fun googleSignIn() {
        val url =
            "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?ei5r49r2ou9pflsn9bas5hvj4c13uroq.apps.googleusercontent.com&response_type=code&redirect_uri=${BuildConfig.REDIRECT_URI}&scope=${BuildConfig.SCOPE}&client_id=${BuildConfig.GOOGLE_CLIENT_ID}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun intentData(uri: Uri?) {
        val code = uri?.getQueryParameter("code")
        if (!code.isNullOrBlank()) {
            viewModel.login(
                body = LoginRequest(code),
                role = "student"
            )
        } else {
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }
    }
}
