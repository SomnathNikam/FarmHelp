package com.example.farmhelp1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashAnimActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_anim2)
       // val lottieAnimationView = findViewById<LottieAnimationView>(R.id.splashanim)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {  startActivity(Intent(this,LoginActivity::class.java))
            finish() },3000)

    }
}