package com.zd.mynewsapp.utils

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import java.util.regex.Pattern

fun isEmailValid(email: CharSequence?): Boolean {
    return if (email == null || TextUtils.isEmpty(email)) {
        Log.v("zakharova", "AuthorizationValidator, isEmailValid(): " +
                "Email is empty or null}")
        false
    } else {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.v("zakharova", "AuthorizationValidator, isEmailValid() = true")
            true
        } else {
            Log.v("zakharova", "AuthorizationValidator, isEmailValid() = false}")
            false
        }
    }
}

fun isPasswordValid(password: CharSequence?): Boolean {
    val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$"
    )
    return if (password == null || TextUtils.isEmpty(password)) {
        Log.v("zakharova", "AuthorizationValidator, isPasswordValid(): " +
                "Password is empty or null}")
        false
    } else {
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            Log.v("zakharova", "AuthorizationValidator, isPasswordValid() = true")
            true
        } else {
            Log.v("zakharova", "AuthorizationValidator, isPasswordValid() = false}")
            false
        }
    }
}

fun isPasswordConfirmed(password: CharSequence?, confirmPassword: CharSequence?): Boolean {
    return if (confirmPassword == null || TextUtils.isEmpty(confirmPassword)) {
        Log.v("zakharova", "AuthorizationValidator, isPasswordConfirmed(): " +
                "Password Confirmation is empty or null}")
        false
    } else {
        if (confirmPassword == password) {
            Log.v("zakharova", "AuthorizationValidator, isPasswordConfirmed() = true")
            true
        } else {
            Log.v("zakharova", "AuthorizationValidator, isPasswordConfirmed() = false}")
            false
        }
    }
}