package com.example.playground.carousel.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.playground.databinding.CarouselViewBinding


class CarouselComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = CarouselViewBinding.inflate(LayoutInflater.from(context), this, true)

    var itemList: List<String> = emptyList()
        set(value) {
            field = value
            binding.emptyState.isVisible = itemList.isEmpty()
            binding.carouselComponent.adapter = CarouselAdapter(value)
        }
}