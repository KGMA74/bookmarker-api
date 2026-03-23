package com.learning.bookmarker_api.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookmarkJpaRepository: JpaRepository<BookmarkEntity, UUID> {
    fun findByTagsContaining(tag: String): List<BookmarkEntity>
    fun findByUrl(url: String): BookmarkEntity?
}