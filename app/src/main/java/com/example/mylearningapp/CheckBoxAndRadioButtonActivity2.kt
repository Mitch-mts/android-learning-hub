package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckBoxAndRadioButtonActivity2 : AppCompatActivity() {

    lateinit var male : CheckBox
    lateinit var female : CheckBox
    lateinit var result : TextView
    lateinit var home : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_check_box_and_radio_button2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        male = findViewById(R.id.checkBox)
        female = findViewById(R.id.checkBox2)
        result = findViewById(R.id.textView3)
        home = findViewById(R.id.home)



        male.setOnClickListener {
            if (male.isChecked) {
                result.text = "You are a male"
                female.isChecked = false
            } else {
                result.text = "What is your gender?"

            }

        }

        female.setOnClickListener {
            if (female.isChecked) {
                result.text = "You are a female"
                male.isChecked = false
            } else {
                result.text = "What is your gender?"

            }

        }

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}