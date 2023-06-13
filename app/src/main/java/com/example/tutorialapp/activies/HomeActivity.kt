package com.example.tutorialapp.activies

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapp.R
import com.example.tutorialapp.adapter.ProductAdapter
import com.example.tutorialapp.model.apis.ProductParams
import com.example.tutorialapp.model.apis.ProductResponse
import com.example.tutorialapp.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var currentPage = 1
    private val limit = 10
    private val productList = mutableListOf<com.example.tutorialapp.model.apis.Product>()
    private val adapter = ProductAdapter(productList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById(R.id.recycler1)
        setUpRecyclerView()
        initProductApi()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                Log.i("huydev", "canScrollVertically" + recyclerView.canScrollVertically(1))
                if (!recyclerView.canScrollVertically(1)) {
                    if (productList.count() == 0) return

                    adapter.isLoadingMore = true
                    adapter.notifyItemChanged(productList.count())
                    currentPage += 1
                    val params = ProductParams(currentPage, limit)
                    ProductRepository().getProducts(params)
                        .enqueue(object : Callback<ProductResponse> {
                            override fun onResponse(
                                call: Call<ProductResponse>,
                                response: Response<ProductResponse>
                            ) {
                                val data = response.body()
                                if (response.isSuccessful) {
                                    if (data != null) {
                                        response.body()?.let { item ->
                                            productList.addAll(item.products!!)
                                            Log.d(
                                                "ProductList",
                                                "productList " + productList.count()
                                            )
                                            adapter.isLoadingMore = false
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                }
                            }

                            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                            }

                        })
                }
            }
        })

    }


    private fun setUpRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)

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
    }

    private fun initProductApi() {
        val params = ProductParams(1, limit)
        ProductRepository().getProducts(params).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                val data = response.body()

                if (response.isSuccessful) {
                    if (data != null) {
                        productList.clear()
                        response.body()?.let { item ->
                            productList.clear()
                            productList.addAll(item.products!!)

                            Log.d("ProductList", "productList " + productList.count())
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }

        })
    }


}