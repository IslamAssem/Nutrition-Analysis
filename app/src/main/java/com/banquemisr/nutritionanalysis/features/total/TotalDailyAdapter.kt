package com.banquemisr.nutritionanalysis.features.total

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banquemisr.entities.response.Ingredient
import com.banquemisr.entities.response.Nutrient
import com.banquemisr.entities.response.RecipeResponse
import com.banquemisr.nutritionanalysis.R
import com.banquemisr.nutritionanalysis.databinding.ItemIngredientBinding
import com.banquemisr.nutritionanalysis.databinding.ItemTotalNutrientBinding
import java.lang.Exception
import java.text.DecimalFormat

class TotalDailyAdapter(private val items: List<Nutrient>) :
    RecyclerView.Adapter<NutrientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutrientViewHolder =
        NutrientViewHolder.instance(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: NutrientViewHolder, position: Int) {
        try {
            holder.bind(items[position])
        }catch (e  :Exception){
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int = items.size
}

class NutrientViewHolder(private val binding: ItemTotalNutrientBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(nutrient : Nutrient) { 
            binding.decimalFormatter = DecimalFormat("#.##")
            binding.nutrient = nutrient
    }

    companion object {
        fun instance(inflater: LayoutInflater, parent: ViewGroup) =
            NutrientViewHolder(ItemTotalNutrientBinding.inflate(inflater, parent, false))
    }
}
fun RecipeResponse.getTotalItemsList() =
    ArrayList<Nutrient>().apply {
        if (totalDaily.ENERC_KCAL != null)
            add(totalDaily.ENERC_KCAL.setLabelResource(R.string.calories))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.calories))
        if (totalDaily.FAT != null)
            add(totalDaily.FAT.setLabelResource(R.string.fat))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.fat))
        if (totalDaily.CHOLE != null)
            add(totalDaily.CHOLE.setLabelResource(R.string.cholesterol))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.cholesterol))
        if (totalDaily.NA != null)
            add(totalDaily.NA.setLabelResource(R.string.sodium))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.sodium))
        if (totalDaily.FIBTG != null)
            add(totalDaily.FIBTG.setLabelResource(R.string.fiber))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.fiber))
        if (totalDaily.SUGAR != null)
            add(totalDaily.SUGAR.setLabelResource(R.string.sugar))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.sugar))
        if (totalDaily.PROCNT != null)
            add(totalDaily.PROCNT.setLabelResource(R.string.protein))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.protein))
        if (totalDaily.VITA_RAE != null)
            add(totalDaily.VITA_RAE.setLabelResource(R.string.vitamin_a))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_a))
        if (totalDaily.VITC != null)
            add(totalDaily.VITC.setLabelResource(R.string.vitamin_c))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_c))
        if (totalDaily.VITB6A != null)
            add(totalDaily.VITB6A.setLabelResource(R.string.vitamin_b6))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_b6))
        if (totalDaily.VITB12 != null)
            add(totalDaily.VITB12.setLabelResource(R.string.vitamin_b12))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_b12))
        if (totalDaily.VITD != null)
            add(totalDaily.VITD.setLabelResource(R.string.vitamin_d))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_d))
        if (totalDaily.TOCPHA != null)
            add(totalDaily.TOCPHA.setLabelResource(R.string.vitamin_e))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_e))
        if (totalDaily.VITK1 != null)
            add(totalDaily.VITK1.setLabelResource(R.string.vitamin_k))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.vitamin_k))
        if (totalDaily.CA != null)
            add(totalDaily.CA.setLabelResource(R.string.calcium))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.calcium))
        if (totalDaily.FE != null)
            add(totalDaily.FE.setLabelResource(R.string.iron))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.iron))
        if (totalDaily.K != null)
            add(totalDaily.K.setLabelResource(R.string.potassium))
        else add(Nutrient("",0.0,"%").setLabelResource(R.string.potassium))
    }