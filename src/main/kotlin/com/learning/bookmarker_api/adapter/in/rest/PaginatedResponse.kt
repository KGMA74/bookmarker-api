package com.learning.bookmarker_api.adapter.`in`.rest

import com.learning.bookmarker_api.domain.model.PageResult

data class PaginatedResponse<T : Any>(
    val data: List<T>,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val isFirst: Boolean,
    val isLast: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
) {
    constructor(page: PageResult<T>) : this(
        data          = page.data,
        totalElements = page.totalElements,
        totalPages    = page.totalPages,
        currentPage   = page.currentPage,
        isFirst       = page.isFirst,
        isLast        = page.isLast,
        hasNext       = page.hasNext,
        hasPrevious   = page.hasPrevious
    )
}