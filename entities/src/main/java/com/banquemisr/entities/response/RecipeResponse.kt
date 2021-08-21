package com.banquemisr.entities.response

import android.os.Parcelable
import com.banquemisr.entities.postdata.Ingredients
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
    @SerializedName("ingredients")
    val ingredients: ArrayList<Ingredient>? = null,
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients? = null,
    @SerializedName("uri")
    val uri: String? = "",
    @SerializedName("yield")
    val yield: Double? = 0.0,
    @SerializedName("totalWeight")
    val totalWeight: Double? = 0.0,
    @SerializedName("totalDaily")
    val totalDaily: TotalDaily
) : Parcelable

@Parcelize
data class TotalDaily(
    val ENERC_KCAL: Nutrient,
    val FAT: Nutrient,
    val FASAT: Nutrient,
    val CHOLE: Nutrient,
    val NA: Nutrient,
    val CHOCDF: Nutrient,
    val FIBTG: Nutrient,
    val SUGAR: Nutrient,
    val PROCNT: Nutrient,
    val CA: Nutrient,
    val VITA_RAE: Nutrient,
    val VITC: Nutrient,
    val VITB6A: Nutrient,
    val VITB12: Nutrient,
    val VITD: Nutrient,
    val TOCPHA: Nutrient,
    val VITK1: Nutrient,
    val FE: Nutrient,
    val K: Nutrient


) : Parcelable