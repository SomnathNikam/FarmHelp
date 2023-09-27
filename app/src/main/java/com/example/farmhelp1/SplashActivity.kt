package com.example.farmhelp1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.farmhelp1.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val Animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)
            binding.farmlogo.startAnimation(Animation)

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },4000)

    }
}