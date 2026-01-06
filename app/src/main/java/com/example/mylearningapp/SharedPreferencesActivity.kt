package com.example.mylearningapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {
    lateinit var sharedPreferencesBinding: ActivitySharedPreferencesBinding
    var count: Int = 0
    var name: String? = null
    var message: String? = null
    var isCheck: Boolean? = null

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sharedPreferencesBinding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        val view = sharedPreferencesBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferencesBinding.counter.setOnClickListener {
            count++
            sharedPreferencesBinding.counter.text = count.toString()
        }

    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }

    fun saveData() {
        sharedPreferences = this.getSharedPreferences("saveData", MODE_PRIVATE)

        name = sharedPreferencesBinding.nameText.text.toString()
        message = sharedPreferencesBinding.multiLine.text.toString()
        isCheck = sharedPreferencesBinding.remember.isChecked

        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("message", message)
        editor.putBoolean("isCheck", isCheck!!)
        editor.putInt("count", count)
        editor.apply()

        Toast.makeText(applicationContext, "Your data has been saved", Toast.LENGTH_SHORT).show()
    }

    fun retrieveData() {
        sharedPreferences = this.getSharedPreferences("saveData", MODE_PRIVATE)

        name = sharedPreferences.getString("name", null)
        message = sharedPreferences.getString("message", null)
        isCheck = sharedPreferences.getBoolean("isCheck", false)
        count = sharedPreferences.getInt("count", 0)

        sharedPreferencesBinding.nameText.setText(name)
        sharedPreferencesBinding.multiLine.setText(message)
        sharedPreferencesBinding.remember.isChecked = isCheck!!
        sharedPreferencesBinding.counter.text = count.toString()

    }
}