package com.example.farmhelp1


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.farmhelp1.Fragments.Home
import com.example.farmhelp1.Fragments.MyProfile
import com.example.farmhelp1.Fragments.SearchActivity
import com.example.farmhelp1.Fragments.info
import com.example.farmhelp1.Fragments.schemes
import com.example.farmhelp1.R.id.frmelayout
import com.example.farmhelp1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        var  bottombar = findViewById<BottomNavigationView>(R.id.bottom_nav)
//
//        val floatingbtn = findViewById<FloatingActionButton>(R.id.angry_btn)

        val toolbar = findViewById<Toolbar>(R.id.actionBar)
        setSupportActionBar(toolbar)


        val searchView = toolbar.menu.findItem(R.id.searching).actionView as androidx.appcompat.widget.SearchView
        searchView.queryHint = "Search..."

        searchView.setOnClickListener {
            var imd = Intent(this, SearchActivity::class.java)
            startActivity(imd)
        }


        val fab: FloatingActionButton= findViewById(R.id.angry_btn)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            val chat = Intent(this,chatbotActivity2::class.java)
            startActivity(chat)
            finish()
        }

//        val list = listOf("Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
//            "Jim","Russel","Donald","Brack","Vladimir")
//          val listview= findViewById<ListView>(R.id.Listview_searchbar)
//        val listAdapter: ArrayAdapter<String>
//
//        listAdapter= ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            list)
//        listview.adapter=listAdapter
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                // Perform search here
//                listAdapter.filter.filter(query)
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Update search results here
//                listAdapter.filter.filter(newText)
//                return true
//            }
//        })
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
               val i = Intent(this, SearchActivity::class.java)
               startActivity(i)
//               Toast.makeText(this,"Searching...",Toast.LENGTH_LONG).show()

           }
           R.id.Contactus -> {
               val i = Intent(this,ContactUsActivity::class.java)
               startActivity(i)
               Toast.makeText(this,"Rate us 5 stars",Toast.LENGTH_LONG).show()

           }
           R.id.logout -> {
               val can = Intent(this,LogoutActivity::class.java)
               startActivity(can)
               Toast.makeText(this,"Logout...",Toast.LENGTH_LONG).show()

           }
           R.id.dark_mode -> {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

           }
           R.id.light_mode -> {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

           }

           else -> {

           }
       }
        return true
    }
    override fun onResume() {
        super.onResume()

        // Hide the toolbar when the fragment is resumed
//        (Fragment as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onPause() {
        super.onPause()

        // Show the toolbar when the fragment is paused (e.g., going to another fragment)
//        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }


}
