package com.zd.mynewsapp.profile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import com.zd.mynewsapp.news_feed.MainActivity
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {

    companion object {
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        showEmail()
        save_btn.setOnClickListener {
            if (isNotEmpty()) {
                showNewsFeed()
            }
        }
    }

    private fun showEmail() {
        val email = intent.getStringExtra(EMAIL)
        Log.v("zakharova", "UserProfileActivity, email = $email")
        shown_email.hint = email
    }

    private fun isNotEmpty(): Boolean {
        var areFieldsNotEmpty = true
        if (TextUtils.isEmpty(first_name.text.toString())) {
            first_name.error = getString(R.string.field_is_required)
            areFieldsNotEmpty = false
        }
        if (TextUtils.isEmpty(second_name.text.toString())) {
            second_name.error = getString(R.string.field_is_required)
            areFieldsNotEmpty = false
        }
        if (TextUtils.isEmpty(phone_number.text.toString())) {
            phone_number.error = getString(R.string.field_is_required)
            areFieldsNotEmpty = false
        }
        if (TextUtils.isEmpty(date_of_birth.text.toString())) {
            date_of_birth.error = getString(R.string.field_is_required)
            areFieldsNotEmpty = false
        }
        return areFieldsNotEmpty
    }

    private fun showNewsFeed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}