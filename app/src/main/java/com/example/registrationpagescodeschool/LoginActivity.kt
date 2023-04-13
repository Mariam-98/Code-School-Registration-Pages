package com.example.registrationpagescodeschool

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.registrationpagescodeschool.LoginContract.Companion.LOGIN_RESULT_KEY
import com.example.registrationpagescodeschool.LoginContract.Companion.USER_NAME_KEY
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {

    lateinit var emailTextInputLayout: TextInputLayout
    lateinit var passwordTextInputLayout: TextInputLayout
    lateinit var loginButton: Button

    private val gson by lazy { Gson() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = LayoutInflater.from(this).inflate(R.layout.activity_login, null, false)
        setContentView(view)

        emailTextInputLayout = findViewById(R.id.emailTextInputLayout)
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout)
        loginButton = findViewById(R.id.loginButton)

        val arr = arrayOf(emailTextInputLayout, passwordTextInputLayout)

        loginButton.setOnClickListener {
          val isValid =  (view as ViewGroup).validateAllViews()
            if(!isValid) return@setOnClickListener


//            if (isValid) {
//
//                val email = emailTextInputLayout.editText?.text.toString()
//                val sharedPrefUser = SharedPreferencesManager.getUserMap()?.get(email)
//
//                if (sharedPrefUser != null) {
//                    if (sharedPrefUser.password == passwordTextInputLayout.editText?.text.toString()) {
//                        setResult(Activity.RESULT_OK, Intent().apply {
//                            putExtra(LOGIN_RESULT_KEY, RegistrationResultEnum.SUCCESS)
//                            putExtra(USER_NAME_KEY, sharedPrefUser.userName)
//                        })
//                        finish()
//                    } else {
//                        Toast.makeText(this, "Wrong password. Please, try again!", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    Toast.makeText(this, "Wrong email. Please, try again!", Toast.LENGTH_SHORT).show()
//                }
//            }
        }

//        emailTextInputLayout.setOnFocusChangeListener { _, hasFocus ->
//            if (!hasFocus) {
//                if (emailTextInputLayout.editText?.text?.isEmpty() == true) {
//                    emailTextInputLayout.error = "This field is required"
//                } else {
//                    emailTextInputLayout.error = null
//                }
//            }
//        }
//
//        passwordTextInputLayout.setOnFocusChangeListener { _, hasFocus ->
//            if (!hasFocus) {
//                if (passwordTextInputLayout.editText?.text?.isEmpty() == true) {
//                    passwordTextInputLayout.error = "This field is required"
//                } else {
//                    passwordTextInputLayout.error = null
//                }
//            }
//        }
    }

    private fun textInputsAreFilled(arr: Array<TextInputLayout>): Boolean {
        var areFilled = true

        for (item in arr) {
            if (item.editText?.text?.isEmpty() == true) {
                areFilled = false
                item.error = "This field is required"
            } else {
                item.error = null
            }
        }
        return areFilled
    }
}