package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ServicesActivity : AppCompatActivity() {

    lateinit var startClassicService : Button
    lateinit var startJobIntentService : Button
    lateinit var stopClassicService : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_services)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startClassicService = findViewById(R.id.startClassicService)
        startJobIntentService = findViewById(R.id.stopJobIntentService)
        stopClassicService = findViewById(R.id.stopClassicService)

        startClassicService.setOnClickListener {
            val intent = Intent(this@ServicesActivity, ClassicServiceExample::class.java)
            startService(intent)
        }

        startJobIntentService.setOnClickListener {
            val intent = Intent(this@ServicesActivity, JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this@ServicesActivity, intent)
        }

        stopClassicService.setOnClickListener {
            val intent = Intent(this@ServicesActivity, ClassicServiceExample::class.java)
            stopService(intent)
        }


    }
}