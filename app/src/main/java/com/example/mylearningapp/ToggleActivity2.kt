package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityToggle2Binding

class ToggleActivity2 : AppCompatActivity() {
    lateinit var toggleBinding: ActivityToggle2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        toggleBinding = ActivityToggle2Binding.inflate(layoutInflater)
        val view =  toggleBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toggleBinding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggleBinding.toggleImage.visibility = View.INVISIBLE
                toggleBinding.textView2.text = getString(R.string.the_image_is_not_visible)
            } else {
                toggleBinding.toggleImage.visibility = View.VISIBLE
                toggleBinding.textView2.text = getString(R.string.the_image_is_visible)
            }
        }



        toggleBinding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}