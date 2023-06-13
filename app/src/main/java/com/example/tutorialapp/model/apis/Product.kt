package com.example.tutorialapp.model.apis

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Product(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("description")
    @Expose(serialize = true)
    var description: String? = null,

    @SerializedName("price")
    @Expose
    var price: Int? = null,

    @SerializedName("discountPercentage")
    @Expose
    var discountPercentage: Double? = null,

    @SerializedName("rating")
    @Expose
    var rating: Double? = null,

    @SerializedName("stock")
    @Expose
    var stock: Int? = null,

    @SerializedName("brand")
    @Expose
    var brand: String? = null,

    @SerializedName("category")
    @Expose
    var category: String? = null,

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null,

    @SerializedName("images")
    @Expose
    var images: List<String>? = null
)

