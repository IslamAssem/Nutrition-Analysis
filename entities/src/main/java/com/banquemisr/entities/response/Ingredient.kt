package com.banquemisr.entities.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlin.math.roundToInt

@Parcelize
data class Ingredient (
    val text : String,
    val parsed : ArrayList<Parsed>
) : Parcelable


@Parcelize
data class Parsed (

    @SerializedName("quantity")
    val quantity : Int,
    @SerializedName("measure")
    val measure : String,
    @SerializedName("foodMatch")
    val foodMatch: String,
    @SerializedName("weight")
    val weight: Double,
    @SerializedName("nutrients")
    val calories : CaloriesContainer
) : Parcelable


@Parcelize
data class CaloriesContainer (
    @SerializedName("ENERC_KCAL")
    val calories :  Nutrient
) : Parcelable{
    fun calories() = "${calories.quantity?.roundToInt()?:1} ${calories.unit}"
}
