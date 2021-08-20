package com.banquemisr.nutritionanalysis.di
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeaturesModule {
    @Provides
    fun getGson() = Gson()
}