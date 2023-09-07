package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.farmhelp1.databinding.ActivityPhoneAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class PhoneAuth : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneAuthBinding
    private  lateinit var auth: FirebaseAuth
    private var currentUser: FirebaseUser?=null
    private var phoneNumber:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhoneAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        currentUser = auth.currentUser
    }
    fun send_home(){
        val login = Intent(this,OTP_activity::class.java)
        startActivity(login)
        finish()
    }
    override  fun onStart(){
        super.onStart()
        if(currentUser==null){
            send_home()
            finish()
        }
        else
        {
            var userInfo = currentUser!!.phoneNumber
            userInfo.toString()



        }

}