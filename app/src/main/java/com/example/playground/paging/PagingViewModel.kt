package com.example.playground.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.playground.paging.entity.Article
import com.example.playground.paging.repository.ArticleRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PagingViewModel(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _articlesLiveData = MutableLiveData<PagingData<Article>>()
    val articlesLiveData: LiveData<PagingData<Article>> = _articlesLiveData

    fun loadMore() {
        viewModelScope.launch {
            repository.articlePagingRepository().collectLatest {
                _articlesLiveData.value = it
            }
        }
    }

}