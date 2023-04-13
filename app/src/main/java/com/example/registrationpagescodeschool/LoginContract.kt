package com.example.registrationpagescodeschool

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract

class LoginContract : ActivityResultContract<Unit, Bundle?>() {

    override fun createIntent(context: Context, input: Unit) = Intent(context, LoginActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?): Bundle? {
        return when (resultCode) {
            Activity.RESULT_OK -> intent?.extras
            else -> null
        }
    }

    companion object {
        const val LOGIN_RESULT_KEY = "login_result_key"
        const val USER_NAME_KEY = "user_name_key"
    }
}