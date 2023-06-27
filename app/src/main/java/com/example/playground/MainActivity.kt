package com.example.playground

import android.app.ActivityOptions
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.carousel.CarouselActivity
import com.example.playground.databinding.ActivityMainBinding
import com.example.playground.guidelines.GuidelineActivity
import com.example.playground.networkcalls.booking.BookingActivity
import com.example.playground.networkcalls.events.EventsActivity
import com.example.playground.paging.PagingActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupButtons()
    }

    private fun setupButtons() {
        binding.guielines.setOnClickListener {
            startActivity(GuidelineActivity.getLaunchIntent(this))
        }

        binding.reuseBooking.setOnClickListener {
            startActivity(
                BookingActivity.getLaunchIntent(this),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        binding.reuseEvents.setOnClickListener {
            startActivity(
                EventsActivity.getLaunchIntent(this),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        binding.carouselComponent.setOnClickListener {
            startActivity(CarouselActivity.getLaunchIntent(this))
        }

        binding.paging.setOnClickListener {
            startActivity(PagingActivity.getLaunchIntent(this))
        }
    }
}