package com.example.farmhelp1.Fragments

//import androidx.appcompat.widget.SearchView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farmhelp1.databinding.FragmentInfoBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

///**
// * A simple [Fragment] subclass.
// * Use the [info.newInstance] factory method to
// * create an instance of this fragment.
// */
class info : Fragment() {
    //

    private var _binding:FragmentInfoBinding? =null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInfoBinding.inflate(inflater,container,false)
     // Start from here
        requireActivity().actionBar?.hide()
    return binding.root
    }
}