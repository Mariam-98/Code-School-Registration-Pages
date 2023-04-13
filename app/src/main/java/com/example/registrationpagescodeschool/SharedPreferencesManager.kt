package com.example.registrationpagescodeschool

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPreferencesManager {
    private const val USER_KEY = "user_key"

    private val gson by lazy { Gson() }

    fun putUser(user: User) {
        val sharedPrefUserMap = getUserMap()
        if (sharedPrefUserMap != null) {
            sharedPrefUserMap[user.email] = user
            SharedPreferencesHelper.put(USER_KEY, gson.toJson(sharedPrefUserMap))
        } else {
            val userMap = mutableMapOf<String, User>()
            userMap[user.email] = user
            SharedPreferencesHelper.put(USER_KEY, gson.toJson(userMap))
        }
//        if (getUserMap() == null) {
//            val userMap = mutableMapOf<String, User>()
//            userMap[user.email] = user
//            SharedPreferencesHelper.put(USER_KEY, gson.toJson(userMap))
//        } else {
//            val sharedPrefUserMap = getUserMap()
//            sharedPrefUserMap?.set(user.email, user)
//            SharedPreferencesHelper.put(USER_KEY, gson.toJson(sharedPrefUserMap))
//        }
    }

    fun getUserMap(): MutableMap<String, User>? = gson.fromJson(SharedPreferencesHelper.getString(USER_KEY), object : TypeToken<MutableMap<String, User>>() {}.type)

}
