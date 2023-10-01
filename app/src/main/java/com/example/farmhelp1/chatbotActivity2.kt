package com.example.farmhelp1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class chatbotActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot2)

        val backarrow = findViewById<ImageView>(R.id.img_back_arrow)
        backarrow.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            //or
           // startActivity(Intent(this,MainActivity::class.java))
        }
    }
}