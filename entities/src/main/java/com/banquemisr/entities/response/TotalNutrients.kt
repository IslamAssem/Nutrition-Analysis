package com.banquemisr.entities.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TotalNutrients(
    @SerializedName("CA")
    val cA: Nutrient? = null,
    @SerializedName("CHOCDF")
    val cHOCDF: Nutrient? = null,
    @SerializedName("CHOLE")
    val cHOLE: Nutrient? = null,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: Nutrient? = null,
    @SerializedName("FAMS")
    val fAMS: Nutrient? = null,
    @SerializedName("FAPU")
    val fAPU: Nutrient? = null,
    @SerializedName("FASAT")
    val fASAT: Nutrient? = null,
    @SerializedName("FAT")
    val fAT: Nutrient? = null,
    @SerializedName("FE")
    val fE: Nutrient? = null,
    @SerializedName("FIBTG")
    val fIBTG: Nutrient? = null,
    @SerializedName("FOLAC")
    val fOLAC: Nutrient? = null,
    @SerializedName("FOLDFE")
    val fOLDFE: Nutrient? = null,
    @SerializedName("FOLFD")
    val fOLFD: Nutrient? = null,
    @SerializedName("K")
    val k: Nutrient? = null,
    @SerializedName("MG")
    val mG: Nutrient? = null,
    @SerializedName("NA")
    val nA: Nutrient? = null,
    @SerializedName("NIA")
    val nIA: Nutrient? = null,
    @SerializedName("P")
    val p: Nutrient? = null,
    @SerializedName("PROCNT")
    val pROCNT: Nutrient? = null,
    @SerializedName("RIBF")
    val rIBF: Nutrient? = null,
    @SerializedName("SUGAR")
    val sUGAR: Nutrient? = null,
    @SerializedName("THIA")
    val tHIA: Nutrient? = null,
    @SerializedName("TOCPHA")
    val tOCPHA: Nutrient? = null,
    @SerializedName("VITA_RAE")
    val vITARAE: Nutrient? = null,
    @SerializedName("VITB12")
    val vITB12: Nutrient? = null,
    @SerializedName("VITB6A")
    val vITB6A: Nutrient? = null,
    @SerializedName("VITC")
    val vITC: Nutrient? = null,
    @SerializedName("VITD")
    val vITD: Nutrient? = null,
    @SerializedName("VITK1")
    val vITK1: Nutrient? = null,
    @SerializedName("WATER")
    val wATER: Nutrient? = null,
    @SerializedName("ZN")
    val zN: Nutrient? = null
) : Parcelable