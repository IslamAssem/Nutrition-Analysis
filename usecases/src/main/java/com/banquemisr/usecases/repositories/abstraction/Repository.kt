package com.banquemisr.usecases.repositories.abstraction

import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getNutritionDetails(ingredient: Ingredients) : Flow<Resource<RecipeResponse>>
}