package com.zd.mynewsapp.authorization

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.zd.mynewsapp.R
import com.zd.mynewsapp.news_feed.MainActivity
import com.zd.mynewsapp.profile.UserProfileActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            login()
        }

        link_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        Log.v("zakharova", "LoginActivity, login()")
        val email = email_input.text.toString()
        val password = password_input.text.toString()
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task ->
            if (task.isSuccessful) {
                Toast.makeText(this, R.string.login_successful, Toast.LENGTH_LONG).show()
                showNewsFeed()
            } else Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show()
        }
    }

    private fun showNewsFeed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}