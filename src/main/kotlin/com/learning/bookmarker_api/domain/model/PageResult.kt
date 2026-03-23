package com.learning.bookmarker_api.domain.model

data class PageResult<T>(
    val data: List<T>,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val isFirst: Boolean,
    val isLast: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)