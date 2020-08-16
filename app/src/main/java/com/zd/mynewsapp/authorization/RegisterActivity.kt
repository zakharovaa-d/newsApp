package com.zd.mynewsapp.authorization

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import com.zd.mynewsapp.profile.UserProfileActivity
import com.zd.mynewsapp.utils.AuthorizationValidator
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            val authorizationValidator = AuthorizationValidator ()
            val emailValidation =
                authorizationValidator.emailValidation(input_new_email.text.toString())
            Log.v("zakharova", "RegisterActivity, btn_register, isValidEmail = $emailValidation")
            if (!emailValidation) input_new_email.error = "Invalid email format"
            else {
                sendEmail()
                showProfile()
            }
        }

        link_login.setOnClickListener {
            showLogin()
        }
    }

    private fun createIntentForUserProfileActivity(): Intent {
        val email = input_new_email.text.toString()
        val intentWithExtras = Intent(this, UserProfileActivity::class.java)

        intentWithExtras.putExtra(UserProfileActivity.EMAIL, email)
        Log.v("zakharova", "RegisterActivity, email = $email")

        return intentWithExtras
    }

    //check if email is in use by another user
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