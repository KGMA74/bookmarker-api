package com.learning.bookmarker_api.domain

import org.springframework.stereotype.Component

@Component
class BookmarkMapper {
    fun toDTO(bookmark: Bookmark): BookmarkDTO = BookmarkDTO(
            bookmark.title,
            bookmark.url
        )

}