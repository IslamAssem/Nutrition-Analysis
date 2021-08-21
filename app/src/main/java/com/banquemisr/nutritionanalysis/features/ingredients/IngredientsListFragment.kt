package com.banquemisr.nutritionanalysis.features.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.banquemisr.nutritionanalysis.databinding.FragmentIngredientsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class IngredientsListFragment : Fragment() {
    private var _binding: FragmentIngredientsBinding? = null
    private val binding: FragmentIngredientsBinding get() = _binding!!
    private val args by navArgs<IngredientsListFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentIngredientsBinding.inflate(inflater).run {
            _binding = this
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.data.ingredients?.let {
            var i = 0
            while (i < it.size){
                if (it[i].parsed.isNullOrEmpty())
                {
                   it.removeAt(i)
                    i--
                }
                i++
            }
            binding.rvIngredients.adapter = IngredientsAdapter(it)
            binding.showTotal.setOnClickListener {
                try {
                    findNavController().navigate(IngredientsListFragmentDirections.showTotal(args.data))
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}