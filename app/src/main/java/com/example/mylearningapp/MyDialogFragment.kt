package com.example.mylearningapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.mylearningapp.fragments.DialogFragmentActivity


class MyDialogFragment : DialogFragment() {
    lateinit var editTextName: EditText
    lateinit var editTextAge: EditText
    lateinit var cancelBtn: Button
    lateinit var okBtn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_dialog, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextAge = view.findViewById(R.id.editTextAge)
        cancelBtn = view.findViewById(R.id.cancelBtn)
        okBtn = view.findViewById(R.id.okBtn)

        dialog!!.window?.setBackgroundDrawableResource(R.drawable.custom_dialog_layout)

        okBtn.setOnClickListener {
            val name: String = editTextName.text.toString()
            val age: Int = editTextAge.text.toString().toInt()


            val dialogActivity: DialogFragmentActivity = activity as DialogFragmentActivity
            dialogActivity.getUserData(name, age)
            dialog!!.dismiss()

        }

        cancelBtn.setOnClickListener {
            dialog!!.dismiss()
        }

        // Inflate the layout for this fragment
        return view
    }

}