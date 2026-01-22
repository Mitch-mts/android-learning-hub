package com.example.mylearningapp.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mylearningapp.R
import com.example.mylearningapp.SecondFragment

class FragmentContentActivity : AppCompatActivity() {
    lateinit var replace: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_fragment_content)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frame)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        replace = findViewById(R.id.buttonReplace)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.fragmentLayout, firstFragment)
        fragmentTransaction.commit()

        replace.setOnClickListener {
            val secondFragment: FragmentManager = supportFragmentManager
            val secondFragmentTransaction : FragmentTransaction = secondFragment.beginTransaction()
            secondFragmentTransaction.replace(R.id.fragmentLayout, SecondFragment())

            // back stack implementation in fragments,  where a fragment opens when you click the back button
            secondFragmentTransaction.addToBackStack(null)
            secondFragmentTransaction.commit()
        }

    }

}