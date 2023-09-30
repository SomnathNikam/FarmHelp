package com.example.farmhelp1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farmhelp1.R


//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [About.newInstance] factory method to
// * create an instance of this fragment.
// */
class MyProfile : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        requireActivity().actionBar?.hide()
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


override fun onDestroyView() {
    super.onDestroyView()

    // Show the action bar when the Fragment is destroyed
    requireActivity().actionBar?.show()
}

}