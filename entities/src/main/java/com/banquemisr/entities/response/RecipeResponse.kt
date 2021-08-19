package com.banquemisr.entities.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeResponse(
    @SerializedName("error")
    val error: String = "",
    @SerializedName("calories")
    val calories: Int? = null,
    @SerializedName("cautions")
    val cautions: List<String>? = null,
    @SerializedName("dietLabels")
    val dietLabels: List<String>? = null,
    @SerializedName("healthLabels")
    val healthLabels: List<String>? = null,
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients? = null,
    @SerializedName("uri")
    val uri: String? = "",
    @SerializedName("yield")
    val yield: Double? = 0.0
) : Parcelable