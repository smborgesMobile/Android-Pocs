package com.example.playground.guidelines

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playground.R
import com.example.playground.databinding.ActivityGuidelineBinding

class GuidelineActivity : AppCompatActivity() {

    private val binding: ActivityGuidelineBinding by lazy {
        ActivityGuidelineBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {
        fun getLaunchIntent(context: Context) =
            Intent(context, GuidelineActivity::class.java)
    }
}