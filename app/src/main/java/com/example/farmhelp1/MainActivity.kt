package com.example.farmhelp1

//import androidx.R
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.farmhelp1.Fragments.Home
import com.example.farmhelp1.Fragments.MyProfile
import com.example.farmhelp1.Fragments.info
import com.example.farmhelp1.Fragments.schemes
import com.example.farmhelp1.R.id.frmelayout
import com.example.farmhelp1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        var  bottombar = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val floatingbtn = findViewById<FloatingActionButton>(R.id.floatingbtn)


//        val search = findViewById<Toolbar>(R.id.actionBar)
//         search.setOnMenuItemClickListener {
//             onCreateOptionsMenu(R.id.searching)
//             onOptionsItemSelected(menu.searching)
//         }
//        var searchActivity = findViewById<SearchView>(R.id.search_bar)
//        searchActivity.setOnClickListener {
//            val imb = Intent(this,SearchActivity::class.java)
//        }


        replaceFragment(Home())

        bottombar.setOnItemSelectedListener {

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

//        floatingbtn.setOnClickListener{
//
//        }

    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val FragmentTransaction = fragmentManager.beginTransaction()
        FragmentTransaction.replace(frmelayout,fragment)
        FragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

         when(item.itemId){
           R.id.searching -> {
               val i = Intent(this,SearchActivity::class.java)
               startActivity(i)
//               Toast.makeText(this,"Searching...",Toast.LENGTH_LONG).show()

           }
           R.id.favourite -> {
//               val i = Intent(this,SearchActivity::class.java)
//               startActivity(i)
               Toast.makeText(this,"Favourite...",Toast.LENGTH_LONG).show()

           }
           R.id.logout -> {
//               val i = Intent(this,SearchActivity::class.java)
//               startActivity(i)
               Toast.makeText(this,"Logout...",Toast.LENGTH_LONG).show()

           }

           else -> {

           }
       }
        return true
    }
//     fun onOptionsItems(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.searching -> {
//                val i = Intent(this, SearchActivity::class.java)
//                startActivity(i)
////               Toast.makeText(this,"Searching...",Toast.LENGTH_LONG).show()
//
//            }


//        }
//        return true
//    }

}
