package com.zd.mynewsapp.model

data class TopHeadlines(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)