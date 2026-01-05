package com.example.mylearningapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.classes.BroadcastExample

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var submit : Button
    lateinit var result : TextView
    lateinit var image : ImageView
    lateinit var checkButton : Button
    lateinit var radioButton : Button
    lateinit var toggle : Button
    lateinit var spinner : Button
    lateinit var toolBar : Button
    lateinit var toast: Button

    lateinit var listView: Button

    lateinit var recyclerView : Button

    lateinit var gridView : Button

    lateinit var webView : Button

    lateinit var fragment : Button
    lateinit var services : Button

    var broadcast = BroadcastExample()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

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


        name = findViewById(R.id.editTextText)
        submit = findViewById(R.id.button)
        result = findViewById(R.id.textView)
        image = findViewById(R.id.image1)
        checkButton = findViewById(R.id.button3)
        radioButton = findViewById(R.id.radio)
        toggle = findViewById(R.id.toggle)
        spinner = findViewById(R.id.spinner)
        toolBar = findViewById(R.id.toolbar)
        toast = findViewById(R.id.toast)
        listView = findViewById(R.id.listView)
        recyclerView = findViewById(R.id.recyclerView)
        gridView = findViewById(R.id.gridView)
        webView = findViewById(R.id.webView)
        fragment = findViewById(R.id.fragment_example)
        services = findViewById(R.id.service_example)




        submit.setOnClickListener {
            val name: String = name.text.toString()
            val resultText = "Hello $name"

            result.text = resultText

            if (image.contentDescription.toString() == "Image1") {
                image.setImageResource(R.drawable.pirates)
                image.contentDescription = "Image2"
            } else {
                image.setImageResource(R.drawable.rickandmorty)
                image.contentDescription = "Image1"
            }

        }

        checkButton.setOnClickListener {
            val intent = Intent(this, CheckBoxAndRadioButtonActivity2::class.java)
            startActivity(intent)
        }

        radioButton.setOnClickListener {
            val intent = Intent(this, RadioButtonActivity2::class.java)
            startActivity(intent)
        }

        toggle.setOnClickListener {
            val intent = Intent(this, ToggleActivity2::class.java)
            startActivity(intent)
        }

        spinner.setOnClickListener {
            val intent = Intent(this, SpinnnerActivity::class.java)
            startActivity(intent)
        }

        toolBar.setOnClickListener {
            val intent = Intent(this, TopAppBarActivity::class.java)
            startActivity(intent)
        }

        toast.setOnClickListener {
            val intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

        listView.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        recyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        gridView.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
        }

        webView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        fragment.setOnClickListener {
            val intent = Intent(this, FragmentLifeCycleActivity::class.java)
            startActivity(intent)
        }

        services.setOnClickListener {
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