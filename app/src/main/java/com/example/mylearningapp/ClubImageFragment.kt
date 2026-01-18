package com.example.mylearningapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ClubImageFragment : Fragment() {
    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_club_image, container, false)
        imageView = view.findViewById(R.id.frameImages)
        val position = arguments?.getInt("position")

        when(position) {
            0 -> imageView.setImageResource(R.drawable.arsenal)
            1 -> imageView.setImageResource(R.drawable.chelsea)
            2 -> imageView.setImageResource(R.drawable.liver)
            3 -> imageView.setImageResource(R.drawable.mancity)
            4 -> imageView.setImageResource(R.drawable.manu)
        }

        // Inflate the layout for this fragment
        return view
    }

}