package com.stackknowledge.design_system.component.toast

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner

class SuccessToastMessage(context: Context) : Toast(context) {
    @Composable
    fun MakeText(
        message: String,
        duration: Int = LENGTH_SHORT,
    ) {
        val context = LocalContext.current
        val views = ComposeView(context)

        views.setContent {
            SuccessToastMessageUtil.SetView(
                message = message,
            )
        }

        views.setViewTreeLifecycleOwner(LocalLifecycleOwner.current)
        views.setViewTreeSavedStateRegistryOwner(LocalSavedStateRegistryOwner.current)
        views.setViewTreeViewModelStoreOwner(LocalViewModelStoreOwner.current)

        this.duration = duration
        this.view = views
        this.setGravity(Gravity.TOP, 0, 4)
        this.show()
    }
}