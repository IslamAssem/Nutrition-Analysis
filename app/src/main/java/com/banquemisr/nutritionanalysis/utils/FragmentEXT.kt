package com.banquemisr.nutritionanalysis.utils

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(@StringRes messageRes : Int){
    Toast.makeText(requireContext(),messageRes,Toast.LENGTH_SHORT).show()
}
fun Fragment.showToast(message : String){
    Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
}