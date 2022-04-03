package com.example.commonui.binding

import android.view.View
import androidx.databinding.BindingConversion

object VisibilityConverter {
    @BindingConversion
    @JvmStatic
    fun convertBooleanToVisibility(isVisible: Boolean): Int {
        return if (isVisible)
            View.VISIBLE
        else
            View.GONE
    }
}
