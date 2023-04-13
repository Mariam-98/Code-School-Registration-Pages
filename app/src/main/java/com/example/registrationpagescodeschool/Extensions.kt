package com.example.registrationpagescodeschool

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import java.io.Serializable

inline fun <reified T : Serializable> Bundle.getCustomSerializable(name: String) = if (Build.VERSION.SDK_INT >= 33) {
    this.getSerializable(name, T::class.java)
} else {
    this.getSerializable(name) as? T
}

fun ViewGroup.validateAllViews(): Boolean {
    return if (!this.isEmpty()) {
        for (i in 0 until this.childCount) {
            val child = this.getChildAt(i)
            if (child is Validatable) {
                child.validate()
            } else if (child is ViewGroup) {
                child.validateAllViews()
            }
        }
        true
    } else {
        true
    }
}