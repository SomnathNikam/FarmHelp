package com.example.farmhelp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.farmhelp1.databinding.ActivityOtpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OTP_activity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding
    private  lateinit var auth: FirebaseAuth
    private var currentUser: FirebaseUser?=null
    private  var phoneNumber: String=""
    private var authId:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()
        currentUser = auth.currentUser
        authId = intent.getStringExtra("otpcr")!!

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this){ task ->

                //.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                    send_home()
                } else {
                    // Sign in failed, display a message and update the UI
                    // Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    fun send_home(){
        val login = Intent(this@OTP_activity,MainActivity::class.java)
        startActivity(login)
        finish()
    }
    override  fun onStart() {
        super.onStart()
        if (currentUser == null) {
            send_home()
            finish()
        } else {
            var userInfo = currentUser!!.phoneNumber
            userInfo.toString()
        }
    }

    fun verifyotp(view: View) {
        val otp:String= binding.verifyotp1.text.toString()
        if (otp.isNotEmpty())
        {
            val credential =PhoneAuthProvider.getCredential(authId,otp)
            signInWithPhoneAuthCredential(credential)
        }
    }
}