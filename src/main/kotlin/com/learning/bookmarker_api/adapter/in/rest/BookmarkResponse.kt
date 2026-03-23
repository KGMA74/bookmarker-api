package com.learning.bookmarker_api.adapter.`in`.rest


data class BookmarkResponse(
    val id: String,
    val url: String,
    val title: String,
    val tags: List<String>,
    val createdAt: String
)