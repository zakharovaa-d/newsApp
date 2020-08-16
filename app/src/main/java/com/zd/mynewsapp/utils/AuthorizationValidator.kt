package com.zd.mynewsapp.utils

import android.content.res.Resources
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.zd.mynewsapp.R
import com.zd.mynewsapp.authorization.RegisterActivity


class AuthorizationValidator {
    fun emailValidation(email: String): Boolean {
        Log.v("zakharova", "AuthorizationValidator, emailValidation(), email = $email")
        return isValidEmail(email)
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return if (target == null || TextUtils.isEmpty(target)) {
            false
        } else {
            Log.v("zakharova", "AuthorizationValidator, isValidEmail(), email = $target")
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}