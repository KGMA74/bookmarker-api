package com.learning.bookmarker_api.adapter.`in`.rest

data class BookmarkRequest(
    val url: String,
    val title: String,
    val tags: List<String> = emptyList()
)