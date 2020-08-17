package com.zd.mynewsapp.authorization

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zd.mynewsapp.R
import kotlinx.android.synthetic.main.activity_authorization.*

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        btnLogin.setOnClickListener {
            showLogin()
        }

        btnRegister.setOnClickListener {
            showRegistration()
        }
    }

    private fun showLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun showRegistration() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}