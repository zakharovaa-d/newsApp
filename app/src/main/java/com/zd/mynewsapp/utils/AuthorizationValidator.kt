package com.zd.mynewsapp.utils

import android.content.res.Resources
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.zd.mynewsapp.R
import com.zd.mynewsapp.authorization.RegisterActivity


class AuthorizationValidator {
    fun emailValidation(email: String): Boolean {
        if (isValidEmail(email)) {
            wrongEmailFormat()
            return false
        }
        return true
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return if (target == null || TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    private fun wrongEmailFormat() {
        val text = Resources.getSystem().getString(R.string.wrong_email_format)
        val registerActivity = RegisterActivity()
        Toast.makeText(registerActivity, text, Toast.LENGTH_SHORT).show()
    }
}