package com.stackknowledge.login

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.GoogleButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.background.LoginBackground
import com.stackknowledge.login.navigation.loginRoute
import com.stackknowledge.login.viewmodel.AuthViewModel

@Composable
fun LoginRoute(
    googleLogin: () -> Unit = {},
    isStudent: (Boolean) -> Unit = {},
    isTeacher: (Boolean) -> Unit = {},
    viewModel: AuthViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
) {
    val roleCheck by viewModel.isStudent.collectAsStateWithLifecycle()

    LoginScreen(
        googleLogin = googleLogin,
        isStudent = isStudent,
        // isTeacher = isTeacher,
        viewModel = viewModel,
        roleCheck = roleCheck,
        // student = student,
        // teacher = teacher,
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    googleLogin: () -> Unit = {},
    isStudent: (Boolean) -> Unit = {},
    // isTeacher: (Boolean) -> Unit = {},
    roleCheck: Boolean,
    // student: Boolean,
    // teacher: Boolean,
) {
    LaunchedEffect(roleCheck) {
        isStudent(roleCheck)
        Log.d("student", roleCheck.toString())
        // isTeacher(!roleCheck)
    }

    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier.fillMaxSize()
            ) {
                Box() {
                    LoginBackground()
                    Column(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = modifier.height(157.dp))
                        Image(
                            painter = painterResource(R.drawable.stack_knowledge_logo),
                            contentDescription = "Stack Knowledge Logo",
                            modifier = modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                        Spacer(modifier = modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.app_title),
                            style = typography.titleLarge,
                            color = colors.BLACK
                        )
                        Spacer(modifier = modifier.height(360.dp))
                        Column(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            GoogleButton(
                                modifier = modifier.height(60.dp),
                                onClick = googleLogin
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPre() {
    //LoginScreen()
}