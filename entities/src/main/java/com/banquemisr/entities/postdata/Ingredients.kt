package com.banquemisr.entities.postdata

import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("ingr")
    val ingredients: List<String>
)