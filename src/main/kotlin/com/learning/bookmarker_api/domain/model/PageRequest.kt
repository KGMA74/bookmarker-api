package com.learning.bookmarker_api.domain.model

data class PageRequest(
    val page: Int,
    val size: Int,
    val sortBy: String = "createdAt",
    val sortDesc: Boolean = true
)