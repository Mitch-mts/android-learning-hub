package com.example.mylearningapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityRadioButton2Binding

class RadioButtonActivity2 : AppCompatActivity() {
    lateinit var radioBinding: ActivityRadioButton2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        radioBinding = ActivityRadioButton2Binding.inflate(layoutInflater)
        val view = radioBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRadio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioBinding.changeBackground.setOnClickListener {
            if (radioBinding.radioButtonGreen.isChecked) {
                radioBinding.mainRadio.setBackgroundColor(Color.GREEN)
            } else if (radioBinding.radioButtonRed.isChecked) {
                radioBinding.mainRadio.setBackgroundColor(Color.RED)
            } else if (radioBinding.radioButtonBlue.isChecked) {
                radioBinding.mainRadio.setBackgroundColor(Color.BLUE)
            } else if (radioBinding.radioButtonYellow.isChecked) {
                radioBinding.mainRadio.setBackgroundColor(Color.YELLOW)
            } else {
                radioBinding.mainRadio.setBackgroundColor(Color.WHITE)
            }

        }


        radioBinding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}