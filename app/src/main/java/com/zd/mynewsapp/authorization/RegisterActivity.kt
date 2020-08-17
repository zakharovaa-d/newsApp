package com.zd.mynewsapp.authorization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import com.zd.mynewsapp.profile.UserProfileActivity
import com.zd.mynewsapp.utils.isEmailValid
import com.zd.mynewsapp.utils.isPasswordConfirmed
import com.zd.mynewsapp.utils.isPasswordValid
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (isCredentialsValid()) {
                sendEmail()
                showProfile()
            }
        }

        link_login.setOnClickListener {
            showLogin()
        }
    }

    private fun isCredentialsValid(): Boolean {
        val email = email_input.text.toString()
        val password = password_input.text.toString()
        val confirmPassword = confirm_password_input.text.toString()

        var isCredentialsValid = true
        if (!isEmailValid(email)) {
            email_input.error = getString(R.string.invalid_email)
            isCredentialsValid = false
        }
        if (!isPasswordValid(password)) {
            password_input.error = getString(R.string.weak_password)
            isCredentialsValid = false
        }
        if (!isPasswordConfirmed(password, confirmPassword)) {
            confirm_password_input.error = getString(R.string.password_mismatch)
            isCredentialsValid = false
        }
        return isCredentialsValid
    }

    private fun createIntentForUserProfileActivity(): Intent {
        val email = email_input.text.toString()
        val intentWithExtras = Intent(this, UserProfileActivity::class.java)

        intentWithExtras.putExtra(UserProfileActivity.EMAIL, email)
        Log.v("zakharova", "RegisterActivity, email = $email")

        return intentWithExtras
    }

    //TODO: check if email is in use by another user
    private fun sendEmail() {
        Log.v("zakharova", "RegisterActivity, sendEmail()")
    }

    private fun showProfile() {
        val intent = createIntentForUserProfileActivity()
        startActivity(intent)
    }

    private fun showLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}