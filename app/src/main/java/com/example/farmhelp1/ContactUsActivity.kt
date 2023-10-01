package com.example.farmhelp1

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

        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        messageEditText = findViewById(R.id.messageEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val message = messageEditText.text.toString()

            // Handle form submission logic here (e.g., send an email, save to a database, etc.)

            // Display a confirmation message
            Toast.makeText(this, "Form submitted!", Toast.LENGTH_SHORT).show()
        }
    }
}






