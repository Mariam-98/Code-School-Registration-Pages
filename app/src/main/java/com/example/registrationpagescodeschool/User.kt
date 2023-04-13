package com.example.registrationpagescodeschool

import java.io.Serializable

data class User(var userName: String, var email: String, var phone: String, var password: String):Serializable
