package com.learning.bookmarker_api.core.port.input

import com.learning.bookmarker_api.core.model.Bookmark
import java.util.UUID

// This interface is the only way to call the domain
interface BookmarkUseCase {
    fun createBookmark(url: String, title: String, tags: List<String>): Bookmark
    fun getBookmark(id: UUID): Bookmark
    fun listBookmarks(tag: String? = null): List<Bookmark>
    fun deleteBookmark(id: UUID)
    fun tagBookmark(id: UUID, tag: String): Bookmark
}