package com.example.mylearningapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listViewItems)

        val countryList =  resources.getStringArray(R.array.countries)

        // adapter
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val countryName = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "You selected $countryName", Toast.LENGTH_SHORT).show()
        }


    }
}