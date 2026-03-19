package com.learning.bookmarker_api.utils

import org.springframework.data.domain.Page


data class PaginatedResponse<T : Any> (
    val data: List<T>,
    val totalElements: Int,
    val totalPages: Int,
    val currentPage: Int,
    val isFirst: Boolean,
    val isLast: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
) {
    constructor(page: Page<T>): this(
        data = page.getContent(),
        totalElements = page.numberOfElements,
        totalPages = page.totalPages,
        currentPage = page.number + 1,
        isFirst = page.isFirst,
        isLast = page.isLast,
        hasNext = page.hasNext(),
        hasPrevious = page.hasPrevious()
    )
}