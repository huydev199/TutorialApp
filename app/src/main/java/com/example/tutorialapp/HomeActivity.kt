package com.example.tutorialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapp.adapter.productAdapter
import com.example.tutorialapp.model.Product

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById(R.id.recycler1)
        val mutableList = mutableListOf<Product>()

        mutableList.add(Product("sdada",213,"casca"));
        mutableList.add(Product("sdada",213,"casca"));
        mutableList.add(Product("sdada",213,"casca"));
        mutableList.add(Product("sdada",213,"casca"));

        val adapter = productAdapter(mutableList,this)
        recyclerView.adapter = adapter
    }
}