package com.sbz.newsly.model

data class NewsModel(
    val totalResults: Int,
    val articles: List<ArticleModel>
)
