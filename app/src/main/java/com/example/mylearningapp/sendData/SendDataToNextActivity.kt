package com.example.mylearningapp.sendData

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.R
import com.example.mylearningapp.databinding.ActivitySendDataToNextBinding

class SendDataToNextActivity : AppCompatActivity() {

    lateinit var sendDataToNextBinding: ActivitySendDataToNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sendDataToNextBinding = ActivitySendDataToNextBinding.inflate(layoutInflater)
        val view = sendDataToNextBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        sendDataToNextBinding.signUpBtn.setOnClickListener {
            val name = sendDataToNextBinding.textName.text.toString()
            val email = sendDataToNextBinding.textEmail.text.toString()
            val phone = sendDataToNextBinding.texPhone.text.toString().toLong()

            val intent = Intent(this, SecondCalledActivity::class.java)
            // the below methods are used to send data to the next activity
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            startActivity(intent)

        }
    }
}