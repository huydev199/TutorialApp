package com.example.tutorialapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapp.adapter.ProductAdapter
import com.example.tutorialapp.model.Product
import java.util.*


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


        val adapter = ProductAdapter(mutableList, this)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val glm = GridLayoutManager(this, 2)
        glm.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {

                if (adapter.getItemViewType(position) == 1) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        recyclerView.layoutManager = glm
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter


        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                Log.i("huydev", "canScrollVertically" + recyclerView.canScrollVertically(1))
                if (!recyclerView.canScrollVertically(1)) {
                    adapter.isLoadingMore = true
                    adapter.notifyItemChanged(mutableList.count())
//                    Log.i("huydev", "mutableList" + mutableList.count())

                    Timer().schedule(object : TimerTask() {
                        override fun run() {
                            // this code will be executed after 2 seconds
                            val newList = mutableListOf<Product>()
                            newList.add(Product("sdada", 213, "casca"));
                            newList.add(Product("sdada", 213, "casca"));
                            newList.add(Product("sdada", 213, "casca"));
                            newList.add(Product("sdada", 213, "casca"));
                            adapter.addData(newList)
                            adapter.isLoadingMore = false
                            runOnUiThread(Runnable { adapter.notifyDataSetChanged() })


//                            adapter.isLoadingMore = false
                        }
                    }, 2000)

                }
            }
        })


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