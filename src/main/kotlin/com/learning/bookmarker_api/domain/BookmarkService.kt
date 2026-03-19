package com.learning.bookmarker_api.domain

import com.learning.bookmarker_api.utils.PaginatedResponse
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookmarkService (
    private val bookmarkRepository: BookmarkRepository,
    private val bookmarkMapper: BookmarkMapper
){
    @Transactional(readOnly = true)
    fun getAllBookmarks(page: Int, size: Int = 10): PaginatedResponse<BookmarkDTO> {
        val pageable: Pageable = PageRequest.of(
            if(page < 0) 0 else page-1,
            size,
            Sort.by(Sort.Direction.DESC, "createdAt")
        )
        //        return PaginatedResponse(
        //            bookmarkRepository.findAll(pageable)
        //                .map(bookmarkMapper::toDTO)
        //        )
        return PaginatedResponse(bookmarkRepository.findAllBookmarks(pageable))
    }
}