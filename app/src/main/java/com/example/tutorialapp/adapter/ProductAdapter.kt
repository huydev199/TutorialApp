package com.example.tutorialapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapp.activies.ProductDetailActivity
import com.example.tutorialapp.R
import com.example.tutorialapp.model.apis.Product

import com.squareup.picasso.Picasso

const val REGULAR_VIEW_TYPE = 0
const val FOOTER_VIEW_TYPE = 1

class ProductAdapter(
    private val list: MutableList<Product> = mutableListOf<Product>(),
    private val context: Context
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var isLoadingMore = false


    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtPrice = view.findViewById<TextView>(R.id.txtPrice)
        val txtBrand = view.findViewById<TextView>(R.id.txtBrand)
        val productImg = view.findViewById<ImageView>(R.id.productImage)

        fun bind(product: Product) {
        }
    }

    class FooterViewHolder(itemView: View) : ViewHolder(itemView) {
        //        val progressBar: ProgressBar
        val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)
        val layoutLoading = itemView.findViewById<ConstraintLayout>(R.id.layoutLoading)

//        init {
//            progressBar = itemView.findViewById(R.id.progressBar)
//            // Define click listener for the ViewHolder's View.
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("huydev", "viewType: " + viewType)

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false);
        val viewFooter: View =
            LayoutInflater.from(parent.context).inflate(R.layout.footer_layout, parent, false);
        if (viewType == REGULAR_VIEW_TYPE) {
            return ViewHolder(view)
        }
        return FooterViewHolder(viewFooter)

//        return FooterViewHolder(viewFooter)
    }

    override fun getItemCount(): Int {
        return list.count() + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemView.setOnClickListener() {
//            Toast.makeText(this.context, "Its toast!", Toast.LENGTH_SHORT).show();
//        }
        when (holder.itemViewType) {
            REGULAR_VIEW_TYPE -> {
                val item = list[position]
                holder.txtName.setText(item.title)
                holder.txtPrice.setText(item.price.toString())
                holder.txtBrand.setText(item.brand)

                Picasso.get()
                    .load(item.thumbnail).into(holder.productImg)

                holder.itemView.setOnClickListener {
                    val i = Intent(context, ProductDetailActivity::class.java)
                    i.putExtra("Id", item.id);
                    context.startActivity(i)
                }
            }
            else -> {
                if (holder is FooterViewHolder) {
                    val footerHolder = holder as FooterViewHolder
                    footerHolder.layoutLoading.visibility =
                        if (isLoadingMore) View.VISIBLE else View.GONE
                }
            }
        }

    }


    override fun getItemViewType(position: Int): Int {
        Log.i("huydev", "View getItemViewType" + list.count())

        return if (position == list.count()) {
            FOOTER_VIEW_TYPE
        } else {
            REGULAR_VIEW_TYPE
        }
//        return REGULAR_VIEW_TYPE
    }

    fun addData(data: MutableList<Product>) {
        list.addAll(data)
    }
}