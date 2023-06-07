package com.example.tutorialapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapp.R
import com.example.tutorialapp.model.Product
import com.squareup.picasso.Picasso

class productAdapter(
    private val list: MutableList<Product> = mutableListOf<Product>(),
    private val context: Context
) : RecyclerView.Adapter<productAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView
        val txtPrice: TextView
        val productImage: ImageView

        init {
            txtName = view.findViewById(R.id.txtName)
            txtPrice = view.findViewById(R.id.txtPrice)
            productImage = view.findViewById(R.id.productImage)

            // Define click listener for the ViewHolder's View.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false);


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.setOnClickListener(){
               Toast.makeText(this.context, "Its toast!", Toast.LENGTH_SHORT).show();
       }
        Picasso.get()
            .load("https://www.w3schools.com/css/img_5terre.jpg")
            .into(holder.productImage);
        holder.txtName.setText("hahaaha")
    }

}