package com.example.registrationpagescodeschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.registrationpagescodeschool.HomeContract.Companion.USER_NAME

class HomeActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.toolbar)

        val userName = intent.getStringExtra(USER_NAME)

        toolbar.title = userName
    }
}