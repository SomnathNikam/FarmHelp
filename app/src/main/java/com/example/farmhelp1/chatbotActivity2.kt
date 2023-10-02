package com.example.farmhelp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class chatbotActivity2 : AppCompatActivity() {


    private lateinit var conversationTextView: TextView
    private lateinit var userInputEditText: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot2)

//        val backarrow = findViewById<ImageView>(R.id.img_back_arrow)
//        backarrow.setOnClickListener {
//            val i = Intent(this,MainActivity::class.java)
//            startActivity(i)
//            //or
//           // startActivity(Intent(this,MainActivity::class.java))
//        }
        conversationTextView = findViewById(R.id.conversationTextView)
        userInputEditText = findViewById(R.id.userInputEditText)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val userInput = userInputEditText.text.toString().trim()
        if (userInput.isNotEmpty()) {
            appendMessage("You: $userInput")
            processUserInput(userInput)
            userInputEditText.setText("")
        }
    }

    private fun appendMessage(message: String) {
        val currentText = conversationTextView.text.toString()
        val newText = "$currentText\n$message"
        conversationTextView.text = newText
    }

    private fun processUserInput(userInput: String) {
        // Here you can implement your chatbot's logic
        // For simplicity, we'll use a predefined set of responses
        val response = getBotResponse(userInput)
        appendMessage("Bot: $response")
    }

    private fun getBotResponse(userInput: String): String {
        // Predefined set of responses (You can replace with your own logic)
        return when (userInput.toLowerCase()) {
            "hello" -> "Hi there!"
            "how are you" -> "I'm just a computer program, but thanks for asking!"
            "what's your name" -> "I'm just a simple chatbot."
            "goodbye" -> "Goodbye! Have a great day!"
            else -> "Sorry, I don't understand."
        }
    }
}


