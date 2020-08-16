package com.zd.mynewsapp.utils

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import java.util.regex.Pattern


class AuthorizationValidator {
    fun emailValidation(email: CharSequence?): Boolean {
        Log.v("zakharova", "AuthorizationValidator, emailValidation()," +
                "isValidEmail = ${isValidEmail(email)}")
        return isValidEmail(email)
    }

    fun passwordValidation(password: CharSequence?): Boolean {
        Log.v("zakharova", "AuthorizationValidator, passwordValidation()," +
                "isStrongPassword = ${isStrongPassword(password)}")
        return isStrongPassword(password)
    }

    fun passwordConfirmation(password: CharSequence?, confirmPassword: CharSequence?): Boolean {
        Log.v("zakharova", "AuthorizationValidator, passwordConfirmation(), " +
                "are password equals = ${password == confirmPassword}")
        return if (confirmPassword == null || TextUtils.isEmpty(confirmPassword)) false
        else password == confirmPassword
    }

    private fun isValidEmail(email: CharSequence?): Boolean {
        return if (email == null || TextUtils.isEmpty(email)) false
        else {
            Log.v("zakharova", "AuthorizationValidator, isValidEmail(), email = $email")
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

    private fun isStrongPassword(password: CharSequence?): Boolean {
        val PASSWORD_PATTERN = Pattern.compile("^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$")
        return if (password == null || TextUtils.isEmpty(password)) false
        else {
            Log.v("zakharova", "AuthorizationValidator, isValidPassword(), password = $password")
            PASSWORD_PATTERN.matcher(password).matches()
        }
    }
}