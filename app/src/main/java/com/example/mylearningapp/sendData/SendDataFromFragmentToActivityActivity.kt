package com.example.mylearningapp.sendData

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.R
import com.example.mylearningapp.databinding.ActivitySendDataFromFragmentToActivityBinding
import com.example.mylearningapp.fragments.SendDataFromFragmentToActivityFragment

class SendDataFromFragmentToActivityActivity : AppCompatActivity() {

    lateinit var sendDataFromFragmentToActivityBinding: ActivitySendDataFromFragmentToActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sendDataFromFragmentToActivityBinding = ActivitySendDataFromFragmentToActivityBinding.inflate(layoutInflater)
        val view = sendDataFromFragmentToActivityBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //adding fragment to an activity
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val myFragment = SendDataFromFragmentToActivityFragment()
        ft.add(R.id.sampleFrame, myFragment)
        ft.commit()
    }

    // function for taking data from fragment
    fun takeDataFromFragment(username: String, email: String) {
        sendDataFromFragmentToActivityBinding.textViewName.text = username
        sendDataFromFragmentToActivityBinding.textViewEmailAddress.text = email

    }
}