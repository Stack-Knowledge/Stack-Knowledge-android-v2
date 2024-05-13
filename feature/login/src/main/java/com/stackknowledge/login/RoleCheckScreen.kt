package com.stackknowledge.login

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.stackknowledge.login.viewmodel.AuthViewModel

@Composable
fun RoleCheckRoute(
    viewModel: AuthViewModel = hiltViewModel(),
    studentCheck: () -> Unit,
    teacherCheck: () -> Unit,
) {
    RoleCheckScreen(
        studentCheck = studentCheck,
        teacherCheck = teacherCheck
    )
}

@Composable
fun RoleCheckScreen(
    modifier: Modifier = Modifier,
    studentCheck: () -> Unit = {},
    teacherCheck: () -> Unit = {}
) {
    Button(
        onClick = { studentCheck() }
    ) {

    }

    Button(
        onClick = { teacherCheck() }
    ) {

    }
}

@Preview
@Composable
fun RoleCheckScreenPre() {
    RoleCheckScreen()
}