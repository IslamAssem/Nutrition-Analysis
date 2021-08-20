package com.banquemisr.nutritionanalysis.features.analysis

import androidx.lifecycle.MutableLiveData
import com.banquemisr.usecases.usecases.abstraction.AnalyseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor(useCase: AnalyseUseCase) {
    val recipeIngredients by lazy {
        MutableLiveData<String>()
    }
}