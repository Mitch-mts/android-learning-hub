package com.example.mylearningapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mylearningapp.R

class SharingFragmentNumberTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sharing_number_two, container, false)

        val name: TextView = view.findViewById(R.id.textViewSecond)
        name.text = arguments?.getString("name")

        // Inflate the layout for this fragment
        return view
    }

}