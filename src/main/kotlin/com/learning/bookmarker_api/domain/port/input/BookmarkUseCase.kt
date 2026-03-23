package com.learning.bookmarker_api.domain.port.input

import com.learning.bookmarker_api.domain.model.Bookmark
import com.learning.bookmarker_api.domain.model.PageRequest
import com.learning.bookmarker_api.domain.model.PageResult
import java.util.UUID

// This interface is the only way to call the domain
interface BookmarkUseCase {
    fun createBookmark(url: String, title: String, tags: List<String>): Bookmark
    fun getBookmark(id: UUID): Bookmark
    fun listBookmarks(tag: String? = null, pageRequest: PageRequest): PageResult<Bookmark>
    fun deleteBookmark(id: UUID)
    fun tagBookmark(id: UUID, tag: String): Bookmark
}