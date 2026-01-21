package com.example.mylearningapp.sendData

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.R
import com.example.mylearningapp.databinding.ActivitySecondCalledBinding

class SecondCalledActivity : AppCompatActivity() {
    lateinit var secondCalledBinding: ActivitySecondCalledBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        secondCalledBinding = ActivitySecondCalledBinding.inflate(layoutInflater)
        val view =  secondCalledBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getLongExtra("phone", 0)

        secondCalledBinding.textViewName.text = "Hello $name"
        secondCalledBinding.textViewEmail.text = "Your email address is $email"
        secondCalledBinding.textViewPhone.text = "Your phone number is $phone"

    }
}