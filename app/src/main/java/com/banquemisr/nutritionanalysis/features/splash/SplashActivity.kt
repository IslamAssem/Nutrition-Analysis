package com.banquemisr.nutritionanalysis.features.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.banquemisr.nutritionanalysis.R
import com.banquemisr.nutritionanalysis.features.MainActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Glide.with(this).load(R.drawable.powered_by).into(findViewById(R.id.mainImage))
        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }
    }
}