package com.learning.bookmarker_api.adapter.out.persistence

import com.learning.bookmarker_api.core.model.Bookmark
import com.learning.bookmarker_api.core.model.Tag
import com.learning.bookmarker_api.core.port.out.BookmarkRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class BookmarkJpaAdapter (
    private val jpa: BookmarkJpaRepository
): BookmarkRepository {

    override fun save(bookmark: Bookmark): Bookmark = jpa.save(bookmark.toEntity()).toDomain()

    override fun findById(id: UUID): Bookmark? = jpa.findById(id).map { it.toDomain() }.orElse(null)

    override fun findAll(): List<Bookmark>  = jpa.findAll().map { it.toDomain() }

    override fun findByTag(tag: String): List<Bookmark> = jpa.findByTagsContaining(tag).map { it.toDomain() }

    override fun deleteById(id: UUID) = jpa.deleteById(id)

    override fun deleteAllInBatch() = jpa.deleteAllInBatch()

    override fun saveAll(bookmarks: List<Bookmark>) = jpa.saveAll(bookmarks.map { it.toEntity() }).map { it.toDomain() }

    // Mapping between domain model and JPA entity stays here
    private fun Bookmark.toEntity() = BookmarkEntity(id, url, title, tags.map { it.name } as MutableList<String>)
    private fun BookmarkEntity.toDomain() = Bookmark(id, url, title, tags.map { Tag(it) }, createdAt)
}