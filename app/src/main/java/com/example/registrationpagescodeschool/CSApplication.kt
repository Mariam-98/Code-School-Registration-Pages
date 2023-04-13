package com.example.registrationpagescodeschool

import android.app.Application

class CSApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesHelper.init(this)
    }
}