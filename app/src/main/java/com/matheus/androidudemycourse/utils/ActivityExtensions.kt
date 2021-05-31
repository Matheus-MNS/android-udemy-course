package com.matheus.androidudemycourse.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


fun Activity.snackBar(view: View, message: Int, length: Int) {
    Snackbar.make(view, message, length)
        .setAction("Action", null)
        .show()
}

fun Activity.changeStatusBarColor(color: Int) {
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(this.context, color)
    }
}

fun Activity.handleActionBarVisibility(visibilityActionEnum: VisibilityActionEnum) {
    when (visibilityActionEnum){
        VisibilityActionEnum.HIDE -> (this as AppCompatActivity).supportActionBar?.hide()
        VisibilityActionEnum.SHOW -> (this as AppCompatActivity).supportActionBar?.show()
    }
}
