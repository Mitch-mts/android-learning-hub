package com.example.mylearningapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.fragments.ClubImageFragment

class SecondListViewActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_list_view_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val position = intent.getIntExtra("position", 0)

        // code to add a fragment to an activity
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val clubImageFragment = ClubImageFragment()

        val bundle = Bundle()
        bundle.putInt("position", position)
        clubImageFragment.arguments = bundle

        fragmentTransaction.add(R.id.secondListFrame, clubImageFragment)
        fragmentTransaction.commit()
    }
}