package com.matheus.androidudemycourse.utils

import android.app.Activity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

fun Activity.changeStatusBarColor(color: Int) {
    val window = this.window
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
