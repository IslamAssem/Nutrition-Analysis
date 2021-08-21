package com.banquemisr.nutritionanalysis.features.total

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.banquemisr.nutritionanalysis.databinding.FragmentIngredientsBinding
import com.banquemisr.nutritionanalysis.databinding.FragmentTotalBinding
import com.banquemisr.nutritionanalysis.features.ingredients.IngredientsAdapter
import com.banquemisr.nutritionanalysis.features.ingredients.IngredientsListFragmentArgs
import com.banquemisr.nutritionanalysis.features.ingredients.IngredientsListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
@AndroidEntryPoint
class TotalFragment : Fragment() {
    private var _binding: FragmentTotalBinding? = null
    private val binding: FragmentTotalBinding get() = _binding!!
    private val args by navArgs<TotalFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentTotalBinding.inflate(inflater).run {
            _binding = this
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvIngredients.adapter = TotalDailyAdapter(args.data.getTotalItemsList())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}