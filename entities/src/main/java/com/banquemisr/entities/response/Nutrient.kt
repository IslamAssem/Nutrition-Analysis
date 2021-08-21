package com.banquemisr.entities.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nutrient(
    @SerializedName("label")
    val label: String,
    @SerializedName("quantity")
    val quantity: Double,
    @SerializedName("unit")
    val _unit: String
) : Parcelable{
    val unit : String
    get() = if (_unit.isNullOrEmpty()) "" else _unit
    var labelRes : Int = 0
    fun setLabelResource(labelRes : Int): Nutrient {
        this.labelRes = labelRes
        return this
    }
}