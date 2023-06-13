package com.example.tutorialapp.repository

import android.util.Log
import com.example.tutorialapp.api.ProductService
import com.example.tutorialapp.api.RetrofitClientInstance
import com.example.tutorialapp.model.apis.Product
import com.example.tutorialapp.model.apis.ProductParams
import com.example.tutorialapp.model.apis.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class ProductRepository {
    private val service: ProductService by lazy {
        RetrofitClientInstance().initRetrofit!!.create(ProductService::class.java)
    }

    fun getProducts(params: ProductParams): Call<ProductResponse> {
        val data = mapOf<String, String>(
            "skip" to params.skip.toString(),
            "limit" to params.limit.toString()
        )
        return service.getProducts(data)
    }

    fun getProductDetail(id: Int): Call<Product> {
        return service.getProductDetail(id)
    }
}