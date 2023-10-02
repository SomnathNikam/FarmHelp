package com.example.farmhelp1.Fragments

//import androidx.appcompat.widget.SearchView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.fragment.app.Fragment

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

///**
// * A simple [Fragment] subclass.
// * Use the [info.newInstance] factory method to
// * create an instance of this fragment.
// */
class info : Fragment() {
    //

    private lateinit var searchView: SearchView
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//

        return  null
    }

    private fun generateData(): List<String> {
        val data = mutableListOf<String>()
        for (i in 1..50) {
            data.add("Item $i")
        }
        return data
    }
}
