package com.example.tutorialapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tutorialapp.R
import com.example.tutorialapp.adapter.ImagePagerAdapter
import com.example.tutorialapp.model.apis.Product
import com.example.tutorialapp.repository.ProductRepository
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDetailActivity : AppCompatActivity() {
    private var imageList = mutableListOf<String>()
    private val imageAdapter = ImagePagerAdapter(imageList, this)

    //    private val txtPrice = findViewById<TextView>(R.id.txtPrice)
    private var txtName: TextView? = null
    private var txtPrice: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val viewpager = findViewById<ViewPager2>(R.id.view_pager)
        val dotIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        txtName = findViewById<TextView>(R.id.txtName)
        txtPrice = findViewById<TextView>(R.id.txtPrice)

        viewpager.adapter = imageAdapter
        dotIndicator.attachTo(viewpager)
        callApi()

    }

    private fun callApi() {
        var intent = getIntent()
        val id = intent.getIntExtra("Id", 0)
        Log.d("myproduct", "get id" + id)


        ProductRepository().getProductDetail(id).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val data = response.body()

                if (response.isSuccessful) {
                    if (data != null) {
                        data.images?.let { imageList.addAll(it) }
                        txtName?.setText(data.title)
                        txtPrice?.setText(data.price.toString())
                        imageAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
            }

        })
    }

}
