package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val register = findViewById<Button>(R.id.register)
        val login = findViewById<Button>(R.id.login)

        register.setOnClickListener {
            val i = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(i)
            finish()
        }
        login.setOnClickListener {
            val i = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}