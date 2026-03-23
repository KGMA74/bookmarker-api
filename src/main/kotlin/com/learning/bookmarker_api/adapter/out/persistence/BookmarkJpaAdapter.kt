package com.learning.bookmarker_api.adapter.out.persistence

import com.learning.bookmarker_api.domain.model.Bookmark
import com.learning.bookmarker_api.domain.model.PageRequest
import com.learning.bookmarker_api.domain.model.PageResult
import com.learning.bookmarker_api.domain.model.Tag
import com.learning.bookmarker_api.domain.port.output.BookmarkRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class BookmarkJpaAdapter (
    private val jpa: BookmarkJpaRepository
): BookmarkRepository {

    override fun save(bookmark: Bookmark): Bookmark = jpa.save(bookmark.toEntity()).toDomain()

    override fun findById(id: UUID): Bookmark? = jpa.findById(id).map { it.toDomain() }.orElse(null)

    override fun findAll(pageRequest: PageRequest): PageResult<Bookmark> {
        val pageable = org.springframework.data.domain.PageRequest.of(
            pageRequest.page - 1,
            pageRequest.size,
            Sort.by(
                if (pageRequest.sortDesc) Sort.Direction.DESC else Sort.Direction.ASC,
                pageRequest.sortBy
            )
        )
        return jpa.findAll(pageable).toPageResult()
    }

    override fun findByTag(tag: String, pageRequest: PageRequest): PageResult<Bookmark> {
        val pageable = org.springframework.data.domain.PageRequest.of(
            pageRequest.page - 1,
            pageRequest.size,
            Sort.by(
                if (pageRequest.sortDesc) Sort.Direction.DESC else Sort.Direction.ASC,
                pageRequest.sortBy
            )
        )
        return jpa.findByTagsContaining(tag, pageable).toPageResult()
    }

    override fun deleteById(id: UUID) = jpa.deleteById(id)

    override fun deleteAllInBatch() = jpa.deleteAllInBatch()

    override fun saveAll(bookmarks: List<Bookmark>) = jpa.saveAll(bookmarks.map { it.toEntity() }).map { it.toDomain() }

    // Mapping between domain model and JPA entity stays here
    private fun Bookmark.toEntity() = BookmarkEntity(id, url, title, tags.map { it.name }.toMutableList())
    private fun BookmarkEntity.toDomain() = Bookmark(id, url, title, tags.map { Tag(it) }, createdAt)
    private fun Page<BookmarkEntity>.toPageResult() = PageResult(
        data         = content.map { it.toDomain() },
        totalElements = totalElements,
        totalPages   = totalPages,
        currentPage  = number + 1,
        isFirst      = isFirst,
        isLast       = isLast,
        hasNext      = hasNext(),
        hasPrevious  = hasPrevious()
    )
}