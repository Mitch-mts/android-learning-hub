package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment


class MyListFragment : ListFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter =
            activity?.let { ArrayAdapter.createFromResource(it, R.array.soccer_clubs, android.R.layout.simple_list_item_1) }

        listAdapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(activity, SecondListViewActivityActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }


    }

}