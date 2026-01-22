package com.example.mylearningapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mylearningapp.R

class BMIFragment : Fragment() {

    lateinit var resultText: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_b_m_i, container, false)

        resultText = view.findViewById(R.id.textViewResult)
        val weight = arguments?.getInt("weight")!!.toInt()
        val height = arguments?.getInt("height")!!.toInt()

        val bmi =((weight * 1000) / (height * height)).toDouble()
        resultText.text = "Your result is $bmi"


        // Inflate the layout for this fragment
        return view
    }

}