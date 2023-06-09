package com.example.tutorialapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.tutorialapp.R
import com.squareup.picasso.Picasso


class ImagePagerAdapter(private val list: MutableList<String>,private val context:Context):RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {
    class ImageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imagePager = view.findViewById<ImageView>(R.id.imagePager)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.image_item_pager, parent, false);
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Picasso.get()
            .load("https://www.befunky.com/images/prismic/f5ca4181-01da-4237-92bf-b6938359503e_hero-blur-image-5.jpg?auto=avif,webp&format=jpg&width=896")
            .into(holder.imagePager);
    }


}