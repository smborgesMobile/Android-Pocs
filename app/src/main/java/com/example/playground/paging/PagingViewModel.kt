package com.example.playground.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.playground.paging.entity.Article
import com.example.playground.paging.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class PagingViewModel(
    private val repository: ArticleRepository
) : ViewModel() {

    /**
     * Stream of [Article]s for the UI.
     */
    val items: Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { repository.articlePagingRepository() }
    )
        .flow
        .cachedIn(viewModelScope)

    companion object {
        private const val ITEMS_PER_PAGE = 50
    }
}