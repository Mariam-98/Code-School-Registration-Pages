package com.example.registrationpagescodeschool

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class ValidatableTextInputLayout @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attr, defStyleAttr) {

    fun enableErrorState(errorText: String) {
        error = errorText
        isErrorEnabled = true
    }

    fun enableDefaultState() {
        isErrorEnabled = false
    }
}