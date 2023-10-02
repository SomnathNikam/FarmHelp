package com.example.farmhelp1.Utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {

    fun getApiInterface():Apinterface{

     return  Retrofit.Builder()
           .baseUrl("")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(Apinterface::class.java)
    }
}