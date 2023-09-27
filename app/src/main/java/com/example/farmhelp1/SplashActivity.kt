package com.example.farmhelp1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private  lateinit var  binding: SplashActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SplashActivity().layoutInflater.inflate(this)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val Animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)


            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },3000)

    }
}