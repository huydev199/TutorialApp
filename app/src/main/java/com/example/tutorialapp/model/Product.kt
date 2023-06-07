package com.example.tutorialapp.model

class Product (
    var name : String? = null,
    var price : Int? = null,
    var image : String? = null,
){
    override fun toString(): String {
        return "Product($name,$price,$image)"
    }
}