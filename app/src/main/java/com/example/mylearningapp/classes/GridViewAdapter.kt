package com.example.mylearningapp.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mylearningapp.R

class GridViewAdapter(
    var context: Context,
    var nameList: ArrayList<String>,
    var imageList: ArrayList<Int>
) : BaseAdapter() {


    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        val view : View = LayoutInflater.from(parent!!.context).inflate(R.layout.gridview_design, parent, false)

        val itemName : TextView = view.findViewById(R.id.textView4)
        val itemImage : ImageView = view.findViewById(R.id.imageView)

        itemName.text = nameList[position]
        itemImage.setImageResource(imageList[position])

        return view
    }
}