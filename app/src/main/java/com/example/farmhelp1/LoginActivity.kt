package com.example.farmhelp1

import android.app.Activity
//import android.app.LauncherActivity
import android.content.ContentValues.TAG
import android.content.Intent
//import android.content.pm.LauncherActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.widget.Button
import android.widget.Toast
//import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.farmhelp1.databinding.ActivityLoginBinding
//import com.example.farmhelp1.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class LoginActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ...
// Initialize Firebase Auth

        FirebaseApp.initializeApp(this)

        auth = FirebaseAuth.getInstance()
        auth = Firebase.auth
//        val gos = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()

//        googleSignInClient = GoogleSignIn.getClient(this, gos)

//        binding.btnSignup.setOnClickListener {
//            auth.signInWithEmailAndPassword(
//                binding.Email.text.toString(),
//                binding.textpassword.text.toString()
//            )
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//
//                        Log.d(TAG, "signInWithEmail:success")
//                        val user = auth.currentUser
//                        Toast.makeText(this, " " + user.toString(), Toast.LENGTH_LONG).show()
//
//
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        //  Log.w(TAG, "signInWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            baseContext,
//                            "Authentication failed.",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//
//                    }
//                }

        binding.btnSignup.setOnClickListener {
            signInGoogle()
        }

//  My code          binding.btngoogle.setOnClickListener {
//                val signInClient = googleSignInClient.signInIntent
//
//                Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
//               val i = Intent(this,MainActivity::class.java)
//               startActivity(i)
//                launcher.launch(signInClient)
//            }
//
//  private val launcher=
//     registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//     { result ->
//
//         if (result.resultCode == RESULT_OK) {
//             val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//
//             if (task.isSuccessful) {
//
//                 val account: GoogleSignInAccount? = task.result
//
//                 val credential=GoogleAuthProvider.getCredential(account?.idToken,null)
//
//                 auth.signInWithCredential(credential).addOnCompleteListener {
//                     if (it.isSuccessful){
//                         Toast.makeText(this,"done",Toast.LENGTH_LONG).show()
//                     }
//                     else
//                     {
//                         Toast.makeText(this,"Not done",Toast.LENGTH_LONG).show()
//                     }
//                 }
//             }
//         } else {
//             Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
//         }
//
// }


            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(
                this,
                gso
            )          //initializes google gso even before we sign in
            binding.btngoogle.setOnClickListener {
                signInGoogle()
            }
        }
        private fun signInGoogle() {
            val signInIntent = googleSignInClient.signInIntent

            launcher.launch(signInIntent)
        }

        private val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {

                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleResults(task)
                }
            }


        private fun handleResults(task: Task<GoogleSignInAccount>) {
            if (task.isSuccessful) {
                val account: GoogleSignInAccount? = task.result
                if (account != null) {
                    updateUI(account)
                }
            } else {
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        private fun updateUI(account: GoogleSignInAccount) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            auth.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("email", account.email)
                    intent.putExtra("name", account.displayName)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                }


            }
        }


//        fun signInGoogle() {
//            val signInIntent = googleSignInClient.signInIntent
//            launcher.launch(signInIntent)
//        }
//
//        val launcher =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//                if (result.resultCode == Activity.RESULT_OK) {
//
//                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                    handleResults(task)
//                }
//            }
//
//        fun handleResults(task: Task<GoogleSignInAccount>) {
//            if (task.isSuccessful) {
//                val account: GoogleSignInAccount? = task.result
//                if (account != null) {
//                    updateUI(account)
//                }
//            } else {
//                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        fun updateUI(account: GoogleSignInAccount) {
//            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//            auth.signInWithCredential(credential).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    val intent: Intent = Intent(this, MainActivity::class.java)
//                    intent.putExtra("email", account.email)
//                    intent.putExtra("name", account.displayName)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
//
//                }
//
//
//            }
    }



//    private fun signInGoogle() {
//        val signInIntent = googleSignInClient.signInIntent
//
//        launcher.launch(signInIntent)
//    }
//
//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//
//                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                handleResults(task)
//            }
//        }
//
//
//    private fun handleResults(task: Task<GoogleSignInAccount>) {
//        if (task.isSuccessful) {
//            val account: GoogleSignInAccount? = task.result
//            if (account != null) {
//                updateUI(account)
//            }
//        } else {
//            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun updateUI(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//        auth.signInWithCredential(credential).addOnCompleteListener {
//            if (it.isSuccessful) {
//                val intent: Intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("email", account.email)
//                intent.putExtra("name", account.displayName)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
//
//            }
//
//
//        }
//    }




