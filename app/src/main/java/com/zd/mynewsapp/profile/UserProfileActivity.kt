package com.zd.mynewsapp.profile

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {

    companion object {
        const val EMAIL = "email"
        val context = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        showEmail()
    }

    private fun showEmail() {
        val email = intent.getStringExtra(EMAIL)
        Log.v("zakharova", "UserProfileActivity, email = $email")
        shown_email.hint = email
        Resources.getSystem().getString(R.string.wrong_email_format)
    }

}