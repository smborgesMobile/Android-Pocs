package com.example.playground.paging.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.playground.databinding.ArticleViewholderBinding
import com.example.playground.paging.entity.Article
import com.example.playground.paging.entity.createdText

class ArticleViewHolder(
    private val binding: ArticleViewholderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.apply {
            binding.title.text = article.title
            binding.description.text = article.description
            binding.created.text = article.createdText
        }
    }
}
