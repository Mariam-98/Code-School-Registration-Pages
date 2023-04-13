package com.example.registrationpagescodeschool

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationpagescodeschool.LoginContract.Companion.LOGIN_RESULT_KEY
import com.example.registrationpagescodeschool.LoginContract.Companion.USER_NAME_KEY

class WelcomeActivity : AppCompatActivity() {
    private lateinit var welcomeLoginButton: Button
    private lateinit var welcomeCreateAccountButton: Button
    private val registerActivityLauncher = registerForActivityResult(RegisterContract()) { registrationResult ->

        when (registrationResult) {
            RegistrationResultEnum.SUCCESS -> Toast.makeText(this, "Registration Success", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
        }
    }

    private val loginActivityLauncher = registerForActivityResult(LoginContract()) { bundle ->

        when (bundle?.getCustomSerializable<RegistrationResultEnum>(LOGIN_RESULT_KEY)) {
            RegistrationResultEnum.SUCCESS -> homeActivityLauncher.launch(bundle.getString(USER_NAME_KEY))
            else -> Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
        }
    }

    private val homeActivityLauncher = registerForActivityResult(HomeContract()) {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        welcomeLoginButton = findViewById(R.id.loginButton)
        welcomeCreateAccountButton = findViewById(R.id.createAccountButton)


        welcomeLoginButton.setOnClickListener {
            loginActivityLauncher.launch(Unit)
        }

        welcomeCreateAccountButton.setOnClickListener {
            registerActivityLauncher.launch(Unit)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        when (requestCode) {
//            1 -> when (resultCode) {
//                SUCCESS_RESULT_CODE -> {
//                    when (data?.getSerializableExtra(LOGIN_RESULT_KEY) as? RegistrationResultEnum) {
//                        RegistrationResultEnum.SUCCESS -> {
//                            val intent = Intent(this, HomeActivity::class.java)
//                            intent.putExtra(USER_NAME_KEY, data.getStringExtra(USER_NAME_KEY))
//                            startActivity(intent)
//                        }
//
//                        else -> {
//                            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
//                        }
//                    }
//                }
//
//                else -> {
//                    Toast.makeText(this, "Failed to send data", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            2 -> when (resultCode) {
//                SUCCESS_RESULT_CODE -> {
//                    when (data?.getSerializableExtra(REGISTER_RESULT_KEY) as? RegistrationResultEnum) {
//                        RegistrationResultEnum.SUCCESS -> {
//                            Toast.makeText(this, "Registration Success", Toast.LENGTH_LONG).show()
//                        }
//
//                        else -> {
//                            Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
//                        }
//                    }
//                }
//
//                else -> {
//                    Toast.makeText(this, "Failed to send data", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//
//
//    }
}