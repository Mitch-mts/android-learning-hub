package com.example.mylearningapp.sendData

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.R
import com.example.mylearningapp.databinding.ActivitySendDataFromActtivityToFragmentBinding
import com.example.mylearningapp.fragments.BMIFragment

class SendDataFromActivityToFragmentActivity : AppCompatActivity() {
    lateinit var sendDataFromActivityToFragmentBinding: ActivitySendDataFromActtivityToFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sendDataFromActivityToFragmentBinding = ActivitySendDataFromActtivityToFragmentBinding.inflate(layoutInflater)
        val view = sendDataFromActivityToFragmentBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val bmiFragment = BMIFragment()
        ft.add(R.id.bmiFrame, bmiFragment)

        sendDataFromActivityToFragmentBinding.btnCalculate.setOnClickListener {
            val weight = sendDataFromActivityToFragmentBinding.editTextWeight.text.toString().toInt()
            val height = sendDataFromActivityToFragmentBinding.editTextHeight.text.toString().toInt()

            // sending data from activity to fragment
            val bundle = Bundle()
            bundle.putInt("weight", weight)
            bundle.putInt("height", height)
            bmiFragment.arguments = bundle

            ft.commit()
        }
    }
}