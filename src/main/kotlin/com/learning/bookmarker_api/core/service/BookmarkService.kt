package com.learning.bookmarker_api.core.service

import com.learning.bookmarker_api.core.exception.BookmarkNotFoundException
import com.learning.bookmarker_api.core.model.Bookmark
import com.learning.bookmarker_api.core.model.BookmarkCreatedEvent
import com.learning.bookmarker_api.core.model.Tag
import com.learning.bookmarker_api.core.port.input.BookmarkUseCase
import com.learning.bookmarker_api.core.port.out.BookmarkRepository
import com.learning.bookmarker_api.core.port.out.EventPublisher
import java.util.UUID

class BookmarkService (
    //    output ports
    private val repository: BookmarkRepository,
    private val eventPublisher: EventPublisher
): BookmarkUseCase {
    override fun createBookmark(url: String, title: String, tags: List<String>): Bookmark {
        val bookmark = Bookmark(
            url = url,
            title = title,
            tags = tags.map { Tag(it) }
        )
        val saved = repository.save(bookmark)
        eventPublisher.publish(BookmarkCreatedEvent(saved.id.toString(), url))
        return saved
    }

    override fun getBookmark(id: UUID): Bookmark =
        repository.findById(id) ?: throw BookmarkNotFoundException(id)

    override fun listBookmarks(tag: String?): List<Bookmark> =
        if (tag != null) repository.findByTag(tag) else repository.findAll()

    override fun tagBookmark(id: UUID, tag: String): Bookmark {
        val bookmark = getBookmark(id).addTag(Tag(tag))
        return repository.save(bookmark)
    }

    override fun deleteBookmark(id: UUID) = repository.deleteById(id)
}