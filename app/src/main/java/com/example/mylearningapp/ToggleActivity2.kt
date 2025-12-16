package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ToggleActivity2 : AppCompatActivity() {
    lateinit var home : Button
    lateinit var image : ImageView
    lateinit var result : TextView
    lateinit var toggleButton : ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toggle2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        home = findViewById(R.id.home)
        toggleButton = findViewById(R.id.toggleButton)
        image = findViewById(R.id.toggleImage)
        result = findViewById(R.id.textView2)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                image.visibility = View.INVISIBLE
                result.text = "The image is not visible"
            } else {
                image.visibility = View.VISIBLE
                result.text = "The image is visible"
            }
        }



        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}