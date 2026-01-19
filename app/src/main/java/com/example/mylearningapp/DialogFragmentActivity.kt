package com.example.mylearningapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityDialogFragmentBinding

class DialogFragmentActivity : AppCompatActivity() {
    lateinit var dialogFragmentBinding: ActivityDialogFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        dialogFragmentBinding = ActivityDialogFragmentBinding.inflate(layoutInflater)
        val view = dialogFragmentBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars .left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dialogFragmentBinding.dialogBtn.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val myDialogFragment = MyDialogFragment()
            myDialogFragment.show(fragmentManager, "MyDialogFragment")
        }

    }

    fun getUserData(name: String, age: Int) {
        dialogFragmentBinding.nameText.text = "Name: $name"
        dialogFragmentBinding.ageText.text = "Age: $age"

    }
}