package com.example.playground.networkcalls

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.view.updateMargins
import com.example.playground.R
import com.example.playground.databinding.ActivityBaseNetworkCallApiBinding

abstract class BaseNetworkCallActivityApi : AppCompatActivity() {

    private val binding: ActivityBaseNetworkCallApiBinding by lazy {
        ActivityBaseNetworkCallApiBinding.inflate(layoutInflater)
    }

    abstract val viewModel: BaseNetworkCallViewModel

    abstract val backgroundColor: Int

    abstract val title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBackgroundColor()

        viewModel.currentList.observe(this) {
            when (it) {
                is BaseNetworkCallViewModel.State.Loading -> {
                    showLoading()
                }
                is BaseNetworkCallViewModel.State.Success -> {
                    configureSuccess(it.eventList)
                }
                else -> Unit
            }
        }

        viewModel.loadData()
    }

    private fun configureSuccess(itemList: List<String>) {
        binding.progressBar.isVisible = false
        binding.title.isVisible = true
        itemList.forEach { title ->
            val textView = TextView(this)
            val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            params.updateMargins(10, 30, 10, 40)
            textView.layoutParams = params
            textView.text = title
            textView.setTextColor(getColor(R.color.black))
            binding.itemList.addView(textView)
        }
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
        binding.title.isVisible = true
    }

    private fun setupBackgroundColor() {
        binding.title.text = title
        binding.root.setBackgroundColor(backgroundColor)
    }
}