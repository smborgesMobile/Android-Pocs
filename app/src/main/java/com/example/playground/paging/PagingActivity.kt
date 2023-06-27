package com.example.playground.paging

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playground.databinding.ActivityPagingBinding
import com.example.playground.paging.adapter.PagingAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PagingActivity : AppCompatActivity() {

    private val binding: ActivityPagingBinding by lazy {
        ActivityPagingBinding.inflate(layoutInflater)
    }

    private val viewModel: PagingViewModel by viewModel()

    private val pagingAdapter: PagingAdapter by lazy { PagingAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collectLatest {
                    pagingAdapter.submitData(it)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                pagingAdapter.loadStateFlow.collect {
                    binding.prependProgress.isVisible = it.source.prepend is LoadState.Loading
                    binding.appendProgress.isVisible = it.source.append is LoadState.Loading
                }
            }
        }
    }

    private fun setupRecyclerView() {
        val decoration = DividerItemDecoration(binding.pagingRecyclerView.context, DividerItemDecoration.VERTICAL)
        binding.pagingRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pagingRecyclerView.adapter = pagingAdapter
        binding.pagingRecyclerView.addItemDecoration(decoration)
    }

    companion object {
        fun getLaunchIntent(context: Context) =
            Intent(context, PagingActivity::class.java)
    }
}