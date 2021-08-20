package com.banquemisr.usecases.remote_datasource.gateway

import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.banquemisr.usecases.datasource.remote.gateway.*
import retrofit2.Response

interface ServerGateway {

    @POST("$NUTRITION_DETAILS?$APP_ID=$API_APP_ID&$APP_KEY=$API_APP_KEY")
    suspend fun getNutritionDetails(@Body ingredient: Ingredients): Response<RecipeResponse>
}