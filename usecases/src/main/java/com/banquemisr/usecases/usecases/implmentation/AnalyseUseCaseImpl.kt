package com.banquemisr.usecases.usecases.implmentation

import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import com.banquemisr.usecases.repositories.abstraction.Repository
import com.banquemisr.usecases.usecases.abstraction.AnalyseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnalyseUseCaseImpl @Inject constructor(private val repository: Repository) : AnalyseUseCase {
    override suspend fun getNutritionDetails(ingredient: Ingredients): Flow<Resource<RecipeResponse>> =
        repository.getNutritionDetails(ingredient)

}