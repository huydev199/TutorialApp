package com.example.tutorialapp.model.apis

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("products")
    @Expose
    var products: MutableList<Product>? = null,

    @SerializedName("total")
    @Expose
    var total: Int? = null,

    @SerializedName("skip")
    @Expose
    var skip: Int? = null,

    @SerializedName("limit")
    @Expose
    var limit: Int? = null

)
