package com.example.registrationpagescodeschool

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

object SharedPreferencesHelper {

    private lateinit var sharedPref: SharedPreferences
    private val editor by lazy { sharedPref.edit() }

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
    }


    fun put(key: String, value: String) = editor.putString(key, value).apply()
    fun put(key: String, value: Int) = editor.putInt(key, value).apply()
    fun put(key: String, value: Boolean) = editor.putBoolean(key, value).apply()

    fun getString(key: String?) = sharedPref.getString(key, null)
    fun getInt(key: String?) = sharedPref.getInt(key, 0)
    fun getBoolean(key: String?) = sharedPref.getBoolean(key, false)
}