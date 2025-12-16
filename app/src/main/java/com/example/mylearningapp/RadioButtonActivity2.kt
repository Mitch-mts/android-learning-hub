package com.example.mylearningapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioButtonActivity2 : AppCompatActivity() {
    lateinit var home : Button
    lateinit var changeButton : Button
    lateinit var green : RadioButton
    lateinit var red : RadioButton
    lateinit var blue : RadioButton
    lateinit var yellow : RadioButton
    lateinit var linearLayout : LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_button2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRadio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        home = findViewById(R.id.home)
        changeButton = findViewById(R.id.changeBackground)
        linearLayout = findViewById(R.id.mainRadio)
        green = findViewById(R.id.radioButtonGreen)
        red = findViewById(R.id.radioButtonRed)
        blue = findViewById(R.id.radioButtonBlue)
        yellow = findViewById(R.id.radioButtonYellow)

        changeButton.setOnClickListener {
            if (green.isChecked) {
                linearLayout.setBackgroundColor(Color.GREEN)
            } else if (red.isChecked) {
                linearLayout.setBackgroundColor(Color.RED)
            } else if (blue.isChecked) {
                linearLayout.setBackgroundColor(Color.BLUE)
            } else if (yellow.isChecked) {
                linearLayout.setBackgroundColor(Color.YELLOW)
            } else {
                linearLayout.setBackgroundColor(Color.WHITE)
            }

        }


        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}