package com.learning.bookmarker_api.domain.port.output

import com.learning.bookmarker_api.domain.model.Bookmark
import com.learning.bookmarker_api.domain.model.PageRequest
import com.learning.bookmarker_api.domain.model.PageResult
import java.util.UUID

interface BookmarkRepository {
    fun save(bookmark: Bookmark): Bookmark
    fun findById(id: UUID): Bookmark?
    fun findAll(pageRequest: PageRequest): PageResult<Bookmark>
    fun findByTag(tag: String, pageRequest: PageRequest): PageResult<Bookmark>
    fun deleteById(id: UUID)
    fun deleteAllInBatch()
    fun saveAll(bookmarks: List<Bookmark>): List<Bookmark>
}
