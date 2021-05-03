package com.matheus.androidudemycourse.utils

import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(color: Int) {
    activity?.changeStatusBarColor(color)
}

fun Fragment.handleActionBarVisibility(visibilityActionEnum: VisibilityActionEnum) {
   activity?.handleActionBarVisibility(visibilityActionEnum)
}
