package com.banquemisr.nutritionanalysis.features.analysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.banquemisr.nutritionanalysis.databinding.FragmentAnalyseBinding
import com.banquemisr.nutritionanalysis.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnalyseFragment : Fragment() {
    private var _binding: FragmentAnalyseBinding? = null
    private val binding: FragmentAnalyseBinding get() = _binding!!
    private val viewModel by viewModels<AnalysisViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAnalyseBinding.inflate(inflater).run {
            _binding = this
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
            binding.analyse.isInvisible = it
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){ nullableError ->
            nullableError?.let { error ->
                val messageRes = error.toString().toIntOrNull()
                if (messageRes != null)
                    showToast(messageRes)
                else showToast(error.toString())

            }
        }
        viewModel.recipeIngredients.observe(viewLifecycleOwner){
            binding.analyse.isEnabled = !it.isNullOrEmpty()
        }
        viewModel.analysisResponse.observe(viewLifecycleOwner){
            it?.let {
                findNavController().navigate(AnalyseFragmentDirections.showIngredients(it))
            }
            binding.progressBar.isVisible = false
            binding.analyse.isInvisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}