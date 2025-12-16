package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner : Spinner
    lateinit var result : TextView
    lateinit var home : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinnner)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.spinner)
        result = findViewById(R.id.result)
        home = findViewById(R.id.home)

        spinner.onItemSelectedListener = this

        val arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item

        )

        arrayAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.adapter = arrayAdapter

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        if (parent != null) {
            result.text = parent.getItemAtPosition(position).toString()
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}