package com.example.mylearningapp.classes

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mylearningapp.R

class FragmentExample : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart method called", "OnStart method called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("OnAttach method called", "OnAttach method called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop method called", "OnStop method called")
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }
}