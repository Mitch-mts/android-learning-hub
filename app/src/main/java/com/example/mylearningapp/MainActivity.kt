package com.example.mylearningapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.classes.BroadcastExample
import com.example.mylearningapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding
    var broadcast = BroadcastExample()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // view binding implementation were all he ids of he components in the view are extracted using the mainBinding variable
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        /**
         * 1.It gets the size of the system bars.2.It adds padding to the root view that is equal
         * to the size of the system bars.This ensures that your content is not hidden behind
         * the system UI, providing a more immersive, edge-to-edge experience for the user.
        * */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainBinding.submitButton.setOnClickListener {
            val name: String = mainBinding.editTextText.text.toString()
            val resultText = "Hello $name"

            mainBinding.textView.text = resultText

            if (mainBinding.image1.contentDescription.toString() == "Image1") {
                mainBinding.image1.setImageResource(R.drawable.pirates)
                mainBinding.image1.contentDescription = "Image2"
            } else {
                mainBinding.image1.setImageResource(R.drawable.rickandmorty)
                mainBinding.image1.contentDescription = "Image1"
            }

        }

        mainBinding.checkButton.setOnClickListener {
            val intent = Intent(this, CheckBoxAndRadioButtonActivity2::class.java)
            startActivity(intent)
        }

        mainBinding.radio.setOnClickListener {
            val intent = Intent(this, RadioButtonActivity2::class.java)
            startActivity(intent)
        }

        mainBinding.toggle.setOnClickListener {
            val intent = Intent(this, ToggleActivity2::class.java)
            startActivity(intent)
        }

        mainBinding.spinner.setOnClickListener {
            val intent = Intent(this, SpinnnerActivity::class.java)
            startActivity(intent)
        }

        mainBinding.toolbar.setOnClickListener {
            val intent = Intent(this, TopAppBarActivity::class.java)
            startActivity(intent)
        }

        mainBinding.toast.setOnClickListener {
            val intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

        mainBinding.listView.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        mainBinding.recyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        mainBinding.gridView.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
        }

        mainBinding.webView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        mainBinding.fragmentExample.setOnClickListener {
            val intent = Intent(this, FragmentLifeCycleActivity::class.java)
            startActivity(intent)
        }

        mainBinding.serviceExample.setOnClickListener {
            val intent = Intent(this, ServicesActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()

        // this is how to define a broadcast receiver for all API levels
        val filter = IntentFilter()
        filter.addAction("android.intent.action.AIRPLANE_MODE")
        registerReceiver(broadcast, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcast)
    }
}