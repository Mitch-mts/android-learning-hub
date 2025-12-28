package com.example.mylearningapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class TopAppBarActivity : AppCompatActivity() {

    lateinit var toolbar: MaterialToolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_top_app_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        toolbar.overflowIcon = AppCompatResources.getDrawable(this, R.drawable.vertical_more)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Icon is Clicked", Toast.LENGTH_SHORT).show()

        }

        toolbar.setOnMenuItemClickListener { item ->
            val message = when(item.itemId) {
                R.id.share -> "Share icon is clicked"
                R.id.edit -> "Edit icon is clicked"
                R.id.settings -> "Settings icon is clicked"
                R.id.signout -> "Sign out icon is clicked"
                else -> "No icon is clicked"
            }

            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            return@setOnMenuItemClickListener true

        }

    }
}