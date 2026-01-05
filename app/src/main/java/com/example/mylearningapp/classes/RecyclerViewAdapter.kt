package com.example.mylearningapp.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylearningapp.R
import de.hdodenhof.circleimageview.CircleImageView


class RecyclerViewAdapter
    (
    var countryNameList: ArrayList<String>,
    var detailsList: ArrayList<String>,
    var imagesList: ArrayList<Int>,
    var context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCountryName = itemView.findViewById<TextView>(R.id.textViewCountryName)
        var textViewDetail = itemView.findViewById<TextView>(R.id.textViewDetail)
        var imageView = itemView.findViewById<CircleImageView>(R.id.country_image)
        var cardView = itemView.findViewById<CardView>(R.id.cardView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {

        holder.textViewCountryName.text = countryNameList[position]
        holder.textViewDetail.text = detailsList[position]
        holder.imageView.setImageResource(imagesList[position])

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected ${countryNameList[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }


}