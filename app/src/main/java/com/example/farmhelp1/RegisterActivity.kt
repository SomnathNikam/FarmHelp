package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.farmhelp1.databinding.ActivityMainBinding
import com.example.farmhelp1.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityRegisterBinding
    private  lateinit var auth:FirebaseAuth
    private var currentUser:FirebaseUser ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        currentUser = auth.currentUser

    }
    fun logout(){
        auth.signOut()
        login()
    }
    fun login(){
        val login = Intent(this@RegisterActivity,PhoneAuth::class.java)
        startActivity(login)
        finish()
    }
    override  fun onStart(){
        super.onStart()
        if(currentUser==null){
            login()
        }
        else
        {
            var userInfo = currentUser!!.phoneNumber
            userInfo.toString()


        }
    }
}