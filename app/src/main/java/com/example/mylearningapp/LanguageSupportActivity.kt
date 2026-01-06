package com.example.mylearningapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityLanguageSupportBinding

class LanguageSupportActivity : AppCompatActivity() {

    /**
     * if you want to use multi language support you must utilise string expressions were strings are defined in the string values
     * xml file */
    lateinit var languageSupportBinding: ActivityLanguageSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        languageSupportBinding = ActivityLanguageSupportBinding.inflate(layoutInflater)
        val view = languageSupportBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        languageSupportBinding.button.setOnClickListener {
            Toast.makeText(applicationContext, getString(R.string.toast), Toast.LENGTH_SHORT).show()
        }

    }
}