package com.example.registrationpagescodeschool

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class RegisterContract: ActivityResultContract<Unit, RegistrationResultEnum?>() {

    override fun createIntent(context: Context, input: Unit) = Intent(context, RegisterActivity::class.java)


    override fun parseResult(resultCode: Int, intent: Intent?): RegistrationResultEnum? {
        return when(resultCode){
            Activity.RESULT_OK -> intent?.extras?.getCustomSerializable(REGISTER_RESULT_KEY)
            else -> null
        }
    }

    companion object{
        const val REGISTER_RESULT_KEY = "register_result_key"
    }
}