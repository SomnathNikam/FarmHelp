package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}