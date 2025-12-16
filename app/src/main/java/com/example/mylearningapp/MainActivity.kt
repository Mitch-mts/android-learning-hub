package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var submit : Button
    lateinit var result : TextView
    lateinit var image : ImageView

    lateinit var checkButton : Button

    lateinit var radioButton : Button
    lateinit var toggle : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /**
         * 1.It gets the size of the system bars.2.It adds padding to the root view that is equal
         * to the size of the system bars.This ensures that your content is not hidden behind
         * the system UI, providing a more immersive, edge-to-edge experience for the user.
        * */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        name = findViewById(R.id.editTextText)
        submit = findViewById(R.id.button)
        result = findViewById(R.id.textView)
        image = findViewById(R.id.image1)
        checkButton = findViewById(R.id.button3)
        radioButton = findViewById(R.id.radio)
        toggle = findViewById(R.id.toggle)




        submit.setOnClickListener {
            val name: String = name.text.toString()
            val resultText = "Hello $name"

            result.text = resultText

            if (image.contentDescription.toString() == "Image1") {
                image.setImageResource(R.drawable.pirates)
                image.contentDescription = "Image2"
            } else {
                image.setImageResource(R.drawable.rickandmorty)
                image.contentDescription = "Image1"
            }

        }

        checkButton.setOnClickListener {
            val intent = Intent(this, CheckBoxAndRadioButtonActivity2::class.java)
            startActivity(intent)
        }

        radioButton.setOnClickListener {
            val intent = Intent(this, RadioButtonActivity2::class.java)
            startActivity(intent)
        }

        toggle.setOnClickListener {
            val intent = Intent(this, ToggleActivity2::class.java)
            startActivity(intent)
        }


    }
}