package com.example.farmhelp1

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.farmhelp1.databinding.ActivityLoginBinding
import com.example.farmhelp1.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ...
// Initialize Firebase Auth

        auth = Firebase.auth
        binding.btnSignup.setOnClickListener{
            auth.signInWithEmailAndPassword(binding.Email.text.toString(), binding.textpassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                       Log.d(TAG, "signInWithEmail:success")
                        val user =auth.currentUser
                        Toast.makeText(this," "+user.toString(),Toast.LENGTH_LONG).show()


                    } else {
                        // If sign in fails, display a message to the user.
                      //  Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

        }
        
        
        

    }
}