package com.example.mylearningapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.mylearningapp.R


class SharingFragmentNumberOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sharing_number_one, container, false)

        val name: EditText = view.findViewById(R.id.editTextSend)
        val send: Button = view.findViewById(R.id.btnSend)

        send.setOnClickListener {
            val username = name.text.toString()

            val bundle = Bundle()
            bundle.putString("name", username)

            //sending data from first fragment to the second fragment
            val secondFragment  = SharingFragmentNumberTwoFragment()
            secondFragment.arguments = bundle

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.transferFrame, secondFragment)
            fragmentTransaction.commit()

        }


        return view
    }

}