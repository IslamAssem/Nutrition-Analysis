package com.banquemisr.usecases.remote_datasource.implmentation

import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import com.banquemisr.usecases.remote_datasource.gateway.getResult
import com.banquemisr.usecases.remote_datasource.abstraction.RemoteDataSource
import com.banquemisr.usecases.remote_datasource.gateway.ServerGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val serverGateway: ServerGateway) :
    RemoteDataSource {
    override suspend fun getNutritionDetails(ingredient: Ingredients): Flow<Resource<RecipeResponse>> =
        flow {
            emit(Resource.loading())
            emit(getResult() {
                serverGateway.getNutritionDetails(ingredient)
            })
        }
}