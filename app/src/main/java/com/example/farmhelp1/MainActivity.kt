package com.example.farmhelp1

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.farmhelp1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

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
                R.id.about_us -> replaceFragment(About())
                else -> {

                }
            }
            true

        }

    }
    private fun replaceFragment(fragment: Fragment){

        var fragmentManager = supportFragmentManager
        var FragmentTransaction = fragmentManager.beginTransaction()
        FragmentTransaction.replace(R.id.frmelayout,fragment)
        FragmentTransaction.commit()
    }



}
