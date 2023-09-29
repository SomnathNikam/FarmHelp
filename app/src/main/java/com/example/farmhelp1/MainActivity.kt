package com.example.farmhelp1

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.farmhelp1.Fragments.Home
import com.example.farmhelp1.Fragments.MyProfile
import com.example.farmhelp1.Fragments.info
import com.example.farmhelp1.Fragments.schemes
import com.example.farmhelp1.R.id.frmelayout
import com.example.farmhelp1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        replaceFragment(Home())

        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.info -> replaceFragment(info())

                R.id.schemes -> replaceFragment(schemes())
                R.id.about_us -> replaceFragment(MyProfile())
                else -> {

                }
            }
            true

        }

    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val FragmentTransaction = fragmentManager.beginTransaction()
        FragmentTransaction.replace(frmelayout,fragment)
        FragmentTransaction.commit()
    }



}
