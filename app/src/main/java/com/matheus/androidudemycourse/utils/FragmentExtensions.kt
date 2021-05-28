package com.matheus.androidudemycourse.utils

import android.view.View
import androidx.fragment.app.Fragment


fun Fragment.snackBar(view: View, message: Int, length: Int) {
    activity?.snackBar(view, message, length)
}
fun Fragment.changeStatusBarColor(color: Int) {
    activity?.changeStatusBarColor(color)
}

fun Fragment.handleActionBarVisibility(visibilityActionEnum: VisibilityActionEnum) {
   activity?.handleActionBarVisibility(visibilityActionEnum)
}
