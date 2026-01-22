package com.example.mylearningapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.mylearningapp.R
import com.example.mylearningapp.sendData.SendDataFromFragmentToActivityActivity


class SendDataFromFragmentToActivityFragment : Fragment() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var submit: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_send_data_from_to_activity, container, false)

        name = view.findViewById(R.id.editTextMyName)
        email = view.findViewById(R.id.editTextMyEmail)
        submit = view.findViewById(R.id.btnSubmit)

        submit.setOnClickListener {
            val name = name.text.toString()
            val email = email.text.toString()

            // sending data from fragment to activity
            val activity = activity as SendDataFromFragmentToActivityActivity
            activity.takeDataFromFragment(name, email)


            // another way to use the method
            // (activity as SendDataFromFragmentToActivityActivity).takeDataFromFragment(name, email)
        }

        // Inflate the layout for this fragment
        return view
    }

}