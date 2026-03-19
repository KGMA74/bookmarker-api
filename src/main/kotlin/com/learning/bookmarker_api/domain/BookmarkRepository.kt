package com.learning.bookmarker_api.domain;

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface BookmarkRepository: JpaRepository<Bookmark, Long> {

    @Query(
        "SELECT new com.learning.bookmarker_api.domain.BookmarkDTO(b.title, b.url) FROM Bookmark b"
    )
    fun findAllBookmarks(pageable: Pageable): Page<BookmarkDTO>
}
