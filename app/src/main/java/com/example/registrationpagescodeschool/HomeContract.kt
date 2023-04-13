package com.example.registrationpagescodeschool

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class HomeContract: ActivityResultContract<String, Unit>() {
    override fun createIntent(context: Context, input: String) = Intent(context, HomeActivity::class.java).putExtra(USER_NAME, input)

    override fun parseResult(resultCode: Int, intent: Intent?) {}

    companion object{
        const val USER_NAME = "user_name"
    }
}