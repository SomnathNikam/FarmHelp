package com.example.farmhelp1.Fragments

//import android.widget.SearchView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.farmhelp1.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {

//    private var param1: String? = null
//    private var param2: String? = null
//    private var _binding: FragmentHomeBinding? = null
//    private var binding: FragmentHomeBinding = _binding!!


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        binding = FragmentHomeBinding.inflate(layoutInflater)
//
////        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
////            param2 = it.getString(ARG_PARAM2)
////        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val views = inflater!!.inflate(R.layout.fragment_home,container,false)
//    _binding = FragmentHomeBinding.inflate(inflater,container,false)


        val listView1 = view?.findViewById<ListView>(R.id.Listview_searchbar)
        var searchBar = view?.findViewById<SearchView>(R.id.search_bar)
        var homeBinding =view?.findViewById<ConstraintLayout>(R.id.fragment_home)
        var frame = view?.findViewById<FrameLayout>(R.id.home)
        var card = view?.findViewById<CardView>(R.id.Cardview)


        val list = listOf("Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
            "Jim","Russel","Donald","Brack","Vladimir")



        var listAdapter: ArrayAdapter<*>

        listAdapter= ArrayAdapter(
           requireContext(),
            android.R.layout.simple_list_item_1,
            list)

            listView1?.adapter=listAdapter

//          _binding?.ListviewSearchbar?.adapter= listAdapter

       searchBar?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchBar.requestFocus()

                        listAdapter.filter.filter(p0)


                return true
            }


            override fun onQueryTextChange(p0:String?): Boolean {

                listAdapter.filter.filter(p0)
                return true
            }
        })

//
//
//
//        return _binding!!.root
//    }


//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment HomeFragm.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Home().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//        val card:CardView = findViewById(R.id.Cardview)








        return homeBinding?.rootView
    }

}