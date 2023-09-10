package com.example.farmhelp1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView

import androidx.fragment.app.Fragment
import com.example.farmhelp1.databinding.FragmentHomeBinding



// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

///**
// * A simple [Fragment] subclass.
// * Use the [Home.newInstance] factory method to
// * create an instance of this fragment.
// */
class Home : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    //private var param1: String? = null
    //private var param2: String? = null
    //private var param1: String? = null
  //  private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, true)


        val arrayList = arrayOf("Deepak", "Amit", "Somnath", "Abhijeet")
        val arrayAdapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1,
            arrayList)


//        val arrayAdapter: ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayList)
       binding.ListviewSearchbar.adapter = arrayAdapter


        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchBar.clearFocus()

                if (arrayList.contains(p0)) {
                    arrayAdapter.filter.filter(p0)
                }

                return false
            }


            override fun onQueryTextChange(p0: String?): Boolean {

                arrayAdapter.filter.filter(p0)
                return false
            }
        })

        return binding.root

    }

//    private fun ArrayAdapter(home: Home, simpleListItem1: Int, arrayList: Array<String>): ArrayAdapter<String> {
//
//    }

//    private fun ArrayAdapter(home: Home, simpleListItem1: Int, arrayList: Array<String>): Int {
//        return
//    }

//    private fun ArrayAdapter(home: Home, simpleListItem1: Int, arrayList: Array<String>): ArrayAdapter<*> {
//
//    }


//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Home.
//         */
//        //
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Home().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment About.
//         */
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            About().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

}
