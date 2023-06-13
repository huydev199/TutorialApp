package com.example.tutorialapp.api

import com.example.tutorialapp.model.apis.Product
import com.example.tutorialapp.model.apis.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProductService {
    @GET("products")
    fun getProducts( @QueryMap options: Map<String, String>): Call<ProductResponse>

    @GET("products/{id}")
    fun getProductDetail( @Path("id") productId: Int): Call<Product>
}