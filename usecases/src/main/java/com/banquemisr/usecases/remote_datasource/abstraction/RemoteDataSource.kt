package com.banquemisr.usecases.remote_datasource.abstraction

import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body

interface  RemoteDataSource {
    suspend fun getNutritionDetails(ingredient: Ingredients) : Flow<Resource<RecipeResponse>>
}