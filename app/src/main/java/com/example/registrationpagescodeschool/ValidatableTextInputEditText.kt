package com.example.registrationpagescodeschool

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.core.content.res.getResourceIdOrThrow
import com.google.android.material.textfield.TextInputEditText

@SuppressLint("ViewConstructor")
class ValidatableTextInputEditText @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputEditText(context, attr, defStyleAttr), Validatable {

    private val attrsArray: TypedArray
    private var textInputLayout: ValidatableTextInputLayout? = null
    private var textInputLayoutId: Int
    private var isRequired: Boolean
    private var validationType: Int


    init {
        attrsArray = context.theme.obtainStyledAttributes(attr, R.styleable.ValidatorTextInputEditTextView, 0, 0)
        textInputLayoutId = attrsArray.getResourceIdOrThrow(R.styleable.ValidatorTextInputEditTextView_textInputLayoutId)
        validationType = attrsArray.getInteger(R.styleable.ValidatorTextInputEditTextView_validationType, 0)
        isRequired = attrsArray.getBoolean(R.styleable.ValidatorTextInputEditTextView_isRequired, false)

        attrsArray.recycle()

        onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validate()
            }
        }
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val v = parent.parent as View
        textInputLayout = v.findViewById(textInputLayoutId)
    }


    override fun validate() {
        if (isRequired) {
            if (text?.isNotEmpty() == true) {
                when (validationType) {
                    0 -> if (Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches()) {
                        textInputLayout?.enableDefaultState()
                    } else {
                        textInputLayout?.enableErrorState("Not valid email")
                    }

                    1 -> if (Patterns.PHONE.matcher(text.toString()).matches()) {
                        textInputLayout?.enableDefaultState()
                    } else {
                        textInputLayout?.enableErrorState("Not valid phone")
                    }

                    2 -> if (Regex("^(?=.*\\d)(?=.*[a-z]).{6,}$").matches(text.toString())) {
                        textInputLayout?.enableDefaultState()
                    } else {
                        textInputLayout?.enableErrorState("Not valid phone")
                    }
                }
            } else {
                textInputLayout?.enableErrorState("Tis field is required!")
            }
        }
    }

    fun setTextInputLayoutId(id: Int) {
        textInputLayoutId = id
    }

    fun setIsRequired(required: Boolean) {
        isRequired = required
    }

    fun setValidationType(enum: ValidationTypeEnum) {
        validationType = enum.value
    }
}