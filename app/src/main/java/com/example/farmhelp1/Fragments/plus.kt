package com.example.farmhelp1.Fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.farmhelp1.databinding.FragmentPlusBinding
class plus : Fragment() {

//    lateinit var listView: ListView
//    lateinit var searchView: SearchView
//    lateinit var  view: View

    private var _binding: FragmentPlusBinding? = null
    private val binding get() = _binding!!
//    private lateinit var binding: PlusFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlusBinding.inflate(inflater, container, false)


     //   listView = view.findViewById(R.id.listView)
   //     searchView = view.findViewById(R.id.searchView)

        // Set up your ListView adapter (e.g., ArrayAdapter)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access views using the binding
        binding.textview.text = "Hello from ViewBinding!"
        val items = arrayOf("Item 1", "Item 2", "Item 3","Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
            "Jim","Russel","Donald","Brack","Vladimir")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, items)
        binding.listView.adapter = adapter

        // Set up the SearchView listener
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Handle search query submission if needed

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Filter the list based on the search query
                adapter.filter.filter(newText)
                return true
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
