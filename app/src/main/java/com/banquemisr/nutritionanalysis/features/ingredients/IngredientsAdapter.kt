package com.banquemisr.nutritionanalysis.features.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.banquemisr.entities.response.Ingredient
import com.banquemisr.entities.response.Parsed
import com.banquemisr.nutritionanalysis.databinding.ItemIngredientBinding

class IngredientsAdapter(private val items: List<Ingredient>) :
    RecyclerView.Adapter<IngredientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder.instance(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class IngredientViewHolder(private val binding: ItemIngredientBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(ingredient: Ingredient) {
        if (ingredient.parsed != null && ingredient.parsed.isNotEmpty())
            binding.ingredient = ingredient.parsed[0]
    }

    companion object {
        fun instance(inflater: LayoutInflater, parent: ViewGroup) =
            IngredientViewHolder(ItemIngredientBinding.inflate(inflater, parent, false))
    }
}