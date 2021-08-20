package com.banquemisr.usecases.repositories.implmentation

import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import com.banquemisr.usecases.remote_datasource.abstraction.RemoteDataSource
import com.banquemisr.usecases.repositories.abstraction.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataSource: RemoteDataSource) : Repository {
    override suspend fun getNutritionDetails(ingredient: Ingredients): Flow<Resource<RecipeResponse>> =
        dataSource.getNutritionDetails(ingredient)
}