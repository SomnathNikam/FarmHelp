package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash = findViewById<ImageView>(R.id.farmlogo)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this,SplashAnimActivity2::class.java))
            finish()
        },3000)





    }
}