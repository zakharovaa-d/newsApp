package com.zd.mynewsapp.authorization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import com.zd.mynewsapp.profile.UserProfileActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    companion object {
        val context = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            sendEmail()
            showProfile()

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

    private fun sendEmail() {
        Log.v("zakharova", "RegisterActivity, sendEmail")
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