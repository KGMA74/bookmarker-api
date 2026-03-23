package com.learning.bookmarker_api.adapter.out.persistence

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookmarkJpaRepository: JpaRepository<BookmarkEntity, UUID> {
    fun findByUrl(url: String): BookmarkEntity?
    fun findByTagsContaining(tag: String, pageable: Pageable): Page<BookmarkEntity>
}