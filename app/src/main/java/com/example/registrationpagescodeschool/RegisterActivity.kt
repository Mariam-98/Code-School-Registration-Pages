package com.example.registrationpagescodeschool

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.registrationpagescodeschool.RegisterContract.Companion.REGISTER_RESULT_KEY
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson

class RegisterActivity : AppCompatActivity() {

    private lateinit var createAccountButton: Button
    private lateinit var userNameTextInputLayout: TextInputLayout
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var phoneTextInputLayout: TextInputLayout
    private lateinit var passwordTextInputLayout: TextInputLayout
    lateinit var confirmPasswordTextInputLayout: TextInputLayout

    private val gson by lazy { Gson() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createAccountButton = findViewById(R.id.createAccountButton)
        userNameTextInputLayout = findViewById(R.id.userNameTextInputLayout)
        emailTextInputLayout = findViewById(R.id.emailTextInputLayout)
        phoneTextInputLayout = findViewById(R.id.phoneTextInputLayout)
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout)
        confirmPasswordTextInputLayout = findViewById(R.id.confirmPasswordTextInputLayout)


        val arr = arrayOf(userNameTextInputLayout, emailTextInputLayout, phoneTextInputLayout, passwordTextInputLayout, confirmPasswordTextInputLayout)


        createAccountButton.setOnClickListener {
            if (!textInputsAreFilled(arr)) {
                return@setOnClickListener
            } else {
                val userName = userNameTextInputLayout.editText?.text.toString()
                val userEmail = emailTextInputLayout.editText?.text.toString()
                val userPhone = phoneTextInputLayout.editText?.text.toString()
                val userPassword = passwordTextInputLayout.editText?.text.toString()

                val user = User(userName, userEmail, userPhone, userPassword)

                if (SharedPreferencesManager.getUserMap()?.containsKey(userEmail) == true) {
                    Toast.makeText(this, "We have already registered user with same email. Please change your email!", Toast.LENGTH_LONG).show()
                } else {
                    SharedPreferencesManager.putUser(user)
                    setResult(Activity.RESULT_OK, Intent().putExtra(REGISTER_RESULT_KEY, RegistrationResultEnum.SUCCESS))
                    finish()
                }
            }
        }
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