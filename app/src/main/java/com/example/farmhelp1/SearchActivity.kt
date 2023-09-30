package com.example.farmhelp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val listview1 = findViewById<ListView>(R.id.Listview_searchbar)
        val searchBar = findViewById<SearchView>(R.id.search_bar)
        val list = listOf("Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
            "Jim","Russel","Donald","Brack","Vladimir")

        val listAdapter: ArrayAdapter<*>

        listAdapter= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list)
        listview1.adapter=listAdapter
//        searchBar.setOnClickListener{
//            searchBar.setQuery("Abhay",true)
//            searchBar.setOnSearchClickListener {
//                list.contains("Abhay")
//            }
//            .\searchBar.focusSearch(binding.searchBar,4000)
//        }

      searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchBar.clearFocus()
                if (list.contains(p0)) {
                    listAdapter.filter.filter("")
                    listAdapter.filter.filter(p0).toString()

                }
                return false
            }


            override fun onQueryTextChange(p0: String?): Boolean {

                listAdapter.filter.filter(p0)
                return true
            }
        })
    }
}