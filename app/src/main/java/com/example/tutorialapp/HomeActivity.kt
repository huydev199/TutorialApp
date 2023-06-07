package com.example.tutorialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));
        mutableList.add(Product("sdada", 213, "casca"));

        Log.i("huydev", "View mutableList" +mutableList.toString())

        val adapter = productAdapter(mutableList, this)
        recyclerView.adapter = adapter
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                if(!recyclerView.canScrollVertically(1)) {
//                }
//            }
//        })


//        recyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener{
//            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//                Toast.makeText(this@HomeActivity, "hello", Toast.LENGTH_SHORT).show()
//                return true
//            }
//
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
//            }
//
//            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
//            }
//        })
    }
}