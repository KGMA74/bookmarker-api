package com.learning.bookmarker_api.core.model

import java.awt.print.Book
import java.time.Instant
import java.util.UUID


data class Bookmark (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val url: String,
    val tags: List<Tag> = emptyList(),
    val createdAt: Instant = Instant.now()
) {
    fun addTag(tag: Tag): Bookmark = copy(tags=tags + tag)

    fun hasTag(name: String): Boolean = tags.any { it.name.equals(name, ignoreCase = true) }
}

