package com.example.farmhelp1

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class rate_us : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)

        val rateUs = findViewById<RatingBar>(R.id.rate_us)
        val textView = findViewById<TextView>(R.id.textView)

        rateUs.setOnRatingBarChangeListener { ratingBar, fl, b ->
            textView.setText("Rating Value : $ratingBar")
        }


    }
}