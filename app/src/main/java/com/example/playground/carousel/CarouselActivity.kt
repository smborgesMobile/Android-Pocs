package com.example.playground.carousel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playground.R
import com.example.playground.databinding.ActivityCarouselBinding

class CarouselActivity : AppCompatActivity() {

    private val binding: ActivityCarouselBinding by lazy {
        ActivityCarouselBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.carouselComponent.itemList = listOf("Item 01", "Item 02", "Item 03", "Item 04")
    }

    companion object {
        fun getLaunchIntent(context: Context) =
            Intent(context, CarouselActivity::class.java)
    }
}