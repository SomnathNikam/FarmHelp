package com.example.farmhelp1.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.farmhelp1.R
import com.example.farmhelp1.ThankyouActivity


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






        return   inflater.inflate(R.layout.fragment_about, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            requireActivity().actionBar?.hide()
            var img = view.findViewById<ImageView>(R.id.git)

            img.setOnClickListener {
                val i = Intent(activity, ThankyouActivity::class.java)
                startActivity(i)
            }


            Glide.with(this)
                .asGif()
                .load(R.drawable.giphy)
                .into(img)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().actionBar?.show()
    }

}