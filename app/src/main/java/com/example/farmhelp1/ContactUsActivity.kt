package com.example.farmhelp1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactUsActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.emailEditText)
        messageEditText = findViewById(R.id.messageEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val message = messageEditText.text.toString()

            // Handle form submission logic here (e.g., send an email, save to a database, etc.)

            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }else{


                    sendEmail()

//                callUs()


                Toast.makeText(this, "Message sent! We will reply you in Shortly", Toast.LENGTH_SHORT).show()
            }


//            callus()

        }

//         fun callus(){
//
//            val intent = Intent().apply {
//                action = ACTION_CALL
//                data = Uri.parse("tel: 9975845368")
//            }
//            startActivity(intent)
//        }
    }

//    private fun callUs() {
//        val intent = Intent().apply {
//                action = ACTION_CALL
//                data = Uri.parse("tel: ")
//            }
//            startActivity(intent)
//    }

    private fun sendEmail() {
           val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:hhht5984@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Contact Us Inquiry")

            emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello,\n\nI have a question:")
            startActivity(Intent.createChooser(emailIntent,"Send Email"))
    }
}






