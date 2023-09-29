package com.example.farmhelp1

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.farmhelp1.Fragments.Home
import com.example.farmhelp1.Fragments.MyProfile
import com.example.farmhelp1.Fragments.info
import com.example.farmhelp1.Fragments.schemes
import com.example.farmhelp1.R.id.frmelayout
import com.example.farmhelp1.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var Toggle: ActionBarDrawerToggle
    private lateinit var Nav_view: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.drawerlayout)




        Toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(Toggle)


        Toggle.syncState()
        Nav_view = findViewById(R.id.Nav_view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home1 -> {
                   val i = Intent(this,Home::class.java)
                    startActivity(i)
                    true
                }

                R.id.info1 -> {
                    val i = Intent(this,info::class.java)
                    startActivity(i)
                    true
                }

                R.id.schemes1 -> {
                    val i = Intent(this,schemes::class.java)
                    startActivity(i)
                    true
                }

                R.id.profile-> {
                    val i = Intent(this,MyProfile::class.java)
                    startActivity(i)
                    true
                }

                else -> {
                    false
                }

            }

        }
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
