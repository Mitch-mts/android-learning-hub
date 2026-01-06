package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityCheckBoxAndRadioButton2Binding

class CheckBoxAndRadioButtonActivity2 : AppCompatActivity() {
    lateinit var checkBoxBinding : ActivityCheckBoxAndRadioButton2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        checkBoxBinding = ActivityCheckBoxAndRadioButton2Binding.inflate(layoutInflater)
        val view = checkBoxBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkBoxBinding.checkBox.setOnClickListener {
            if (checkBoxBinding.checkBox.isChecked) {
                checkBoxBinding.textView3.text = "You are a male"
                checkBoxBinding.checkBox2.isChecked = false
            } else {
                checkBoxBinding.textView3.text = "What is your gender?"

            }

        }

        checkBoxBinding.checkBox2.setOnClickListener {
            if (checkBoxBinding.checkBox2.isChecked) {
                checkBoxBinding.textView3.text = "You are a female"
                checkBoxBinding.checkBox.isChecked = false
            } else {
                checkBoxBinding.textView3.text = "What is your gender?"

            }

        }

        checkBoxBinding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}