package com.example.mylearningapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylearningapp.classes.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var countryNameList = ArrayList<String>()
    var detailsList = ArrayList<String>()
    var imagesList = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)

        countryNameList.add("Zimbabwe")
        countryNameList.add("USA")
        countryNameList.add("Canada")
        countryNameList.add("Mexico")
        countryNameList.add("Japan")

        detailsList.add("This is Zimbabwe")
        detailsList.add("This is USA")
        detailsList.add("This is Canada")
        detailsList.add("This is Mexico")
        detailsList.add("This is Japan")

        imagesList.add(R.drawable.zim)
        imagesList.add(R.drawable.usa)
        imagesList.add(R.drawable.canada)
        imagesList.add(R.drawable.mexico)
        imagesList.add(R.drawable.japan)

        val adapter =
            RecyclerViewAdapter(countryNameList, detailsList, imagesList, this@RecyclerViewActivity)
        recyclerView.adapter = adapter

    }
}