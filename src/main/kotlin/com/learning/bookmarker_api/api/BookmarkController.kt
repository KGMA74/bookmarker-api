package com.learning.bookmarker_api.api

import com.learning.bookmarker_api.domain.BookmarkDTO
import com.learning.bookmarker_api.domain.BookmarkService
import com.learning.bookmarker_api.utils.PaginatedResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/bookmarks")
class BookmarkController (
    private val bookmarkService: BookmarkService
){

    @GetMapping
    fun getAllBookmarks(
        @RequestParam("page", defaultValue = "1") page: Int,
        @RequestParam(value = "size") size: Int = 10
    ): PaginatedResponse<BookmarkDTO> = bookmarkService.getAllBookmarks(page, size)
}