package com.example.playground.guidelines.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.playground.databinding.ZeldaCardItemViewBinding

class CardZeldaCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding: ZeldaCardItemViewBinding =
        ZeldaCardItemViewBinding.inflate(LayoutInflater.from(context), this, true)
}