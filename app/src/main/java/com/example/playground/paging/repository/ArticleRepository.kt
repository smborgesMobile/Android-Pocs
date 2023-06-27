package com.example.playground.paging.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.playground.paging.ArticlePagingSource
import com.example.playground.paging.entity.Article
import kotlinx.coroutines.flow.Flow

class ArticleRepository {

    fun articlePagingRepository(): Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { ArticlePagingSource() }
    ).flow

    companion object {
        private const val ITEMS_PER_PAGE = 50
    }
}
