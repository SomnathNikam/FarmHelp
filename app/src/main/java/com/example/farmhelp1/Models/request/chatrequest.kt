package com.example.farmhelp1.Models.request

data class chatrequest(
    val max_tokens: Int,
    val model: String,
    val prompt: String,
    val temperature: Double
)