package com.example.farmhelp1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farmhelp1.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentHomeBinding? = null

    //    private lateinit var binding: FragmentHomeBinding
    private var binding: FragmentHomeBinding = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


//    _binding = FragmentHomeBinding.inflate(inflater,container,false)
////        val listView1:ListView =
//        val list = listOf("Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
//            "Jim","Russel","Donald","Brack","Vladimir")
//
//        var listAdapter: ArrayAdapter<*>
//
//        listAdapter= ArrayAdapter(
//           requireContext(),
//            R.layout.simple_list_item_1,
//            list)
////        binding.Listview_searchbar.adapter=listAdapter
//        _binding.Listview_searchbar.adapter = listAdapter
//
//        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(list: String?): Boolean {
//               binding.searchBar.requestFocus()
////                if (list.contains(p0)) {
////                    listAdapter.filter.filter(p0)
////                }
//                listAdapter.filter.filter(list.toString())
//                return false
//            }
//
//
//            override fun onQueryTextChange(list:String?): Boolean {
//
//                listAdapter.filter.filter(list.toString())
//                return false
//            }
//        })
//
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








        return binding.root
    }

}