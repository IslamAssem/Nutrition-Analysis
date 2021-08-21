package com.banquemisr.nutritionanalysis.features.analysis

import androidx.lifecycle.*
import com.banquemisr.entities.Resource
import com.banquemisr.entities.postdata.Ingredients
import com.banquemisr.entities.response.RecipeResponse
import com.banquemisr.nutritionanalysis.R
import com.banquemisr.nutritionanalysis.utils.SingleLiveEvent
import com.banquemisr.usecases.usecases.abstraction.AnalyseUseCase
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel constructor(
    private val useCase: AnalyseUseCase,
    private val ioDispatcher: CoroutineDispatcher,
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {
    @Inject
    constructor(useCase: AnalyseUseCase) : this(useCase, Dispatchers.IO, Dispatchers.Main)

    val analysisResponse by lazy {
        SingleLiveEvent<RecipeResponse?>()
    }
    val errorMessage by lazy {
        MutableLiveData<Any?>(null)
    }
    val isLoading by lazy {
        SingleLiveEvent<Boolean>()
    }
    val recipeIngredients by lazy {
        MutableLiveData<String>("")
    }

    fun analyse() {
        viewModelScope.launch(ioDispatcher) {
            val ingredients: List<String> =
                if (recipeIngredients.value!!.contains("\n"))
                    recipeIngredients.value!!.split("\n") else listOf(recipeIngredients.value.toString())
            useCase.getNutritionDetails(Ingredients(ingredients))
                .catch {
                    withContext(mainDispatcher) {
                        errorMessage.value = it.message
                    }
                }
                .collect {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            if (it.data?.error.isNullOrEmpty()) {
                                withContext(mainDispatcher){
                                    analysisResponse.value = it.data!!
                                }
                            } else {
                                withContext(mainDispatcher){
                                    isLoading.value = false
                                    errorMessage.value = it.data?.error
                                }
                            }
                        }
                        Resource.Status.LOADING -> {
                            withContext(mainDispatcher) {
                                isLoading.value = true
                            }
                        }
                        Resource.Status.ERROR -> {
                            withContext(mainDispatcher) {
                                isLoading.value = false
                                when {
                                    it.data != null -> {
                                        errorMessage.value = it.data!!.error
                                    }
                                    it.javaClass == UnknownHostException::class.java ->
                                        errorMessage.value = (
                                                R.string.no_internet_connection
                                                )
                                    else -> errorMessage.value = it.message
                                }
                            }
                        }
                    }
                }

        }
    }
}