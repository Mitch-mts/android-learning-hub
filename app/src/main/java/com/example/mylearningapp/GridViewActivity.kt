package com.example.mylearningapp

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.classes.GridViewAdapter

class GridViewActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    var nameList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridView = findViewById(R.id.gridView)
        fillArrays()

        val adapter = GridViewAdapter(this@GridViewActivity, nameList, imageList)
        gridView.adapter = adapter

        gridView.setOnItemClickListener {
                _, _, position, _ ->

            Toast.makeText(this@GridViewActivity, "You selected ${nameList[position]}", Toast.LENGTH_SHORT).show()
        }

    }

    fun fillArrays() {
        nameList.add("USA")
        nameList.add("Canada")
        nameList.add("Mexico")
        nameList.add("Zimbabwe")
        nameList.add("Japan")
        nameList.add("Rick and Morty")
        nameList.add("Pirates of the Caribbean")
        nameList.add("Ice")
        nameList.add("Fire")
        nameList.add("Defender")

        imageList.add(R.drawable.usa)
        imageList.add(R.drawable.canada)
        imageList.add(R.drawable.mexico)
        imageList.add(R.drawable.zim)
        imageList.add(R.drawable.japan)
        imageList.add(R.drawable.rickandmorty)
        imageList.add(R.drawable.pirates)
        imageList.add(R.drawable.ice)
        imageList.add(R.drawable.fire)
        imageList.add(R.drawable.defender)



    }
}