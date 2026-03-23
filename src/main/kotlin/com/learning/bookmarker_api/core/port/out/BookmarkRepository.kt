package com.learning.bookmarker_api.core.port.out

import com.learning.bookmarker_api.core.model.Bookmark
import java.util.UUID

interface BookmarkRepository {
    fun save(bookmark: Bookmark): Bookmark
    fun findById(id: UUID): Bookmark?
    fun findAll(): List<Bookmark>
    fun findByTag(tag: String): List<Bookmark>
    fun deleteById(id: UUID)
    fun deleteAllInBatch()
    fun saveAll(bookmarks: List<Bookmark>): List<Bookmark>
}
