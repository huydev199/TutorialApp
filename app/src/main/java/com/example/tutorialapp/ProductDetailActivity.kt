package com.example.tutorialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.tutorialapp.adapter.ImagePagerAdapter
import com.example.tutorialapp.model.Product
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val viewpager = findViewById<ViewPager2>(R.id.view_pager)
        val dotIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)

        val imageList = mutableListOf<String>()
        imageList.add("sadas")
        imageList.add("sadas")
        imageList.add("sadas")
        imageList.add("sadas")
        val imageAdapter = ImagePagerAdapter(imageList,this)
        viewpager.adapter = imageAdapter
        dotIndicator.attachTo(viewpager)
    }

}
