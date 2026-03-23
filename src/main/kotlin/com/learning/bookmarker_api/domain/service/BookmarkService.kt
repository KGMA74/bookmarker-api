package com.learning.bookmarker_api.domain.service

import com.learning.bookmarker_api.domain.exception.BookmarkNotFoundException
import com.learning.bookmarker_api.domain.model.Bookmark
import com.learning.bookmarker_api.domain.model.BookmarkCreatedEvent
import com.learning.bookmarker_api.domain.model.PageRequest
import com.learning.bookmarker_api.domain.model.PageResult
import com.learning.bookmarker_api.domain.model.Tag
import com.learning.bookmarker_api.domain.port.input.BookmarkUseCase
import com.learning.bookmarker_api.domain.port.output.BookmarkRepository
import com.learning.bookmarker_api.domain.port.output.EventPublisher
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

    override fun listBookmarks(tag: String?, pageRequest: PageRequest): PageResult<Bookmark> =
        if (tag != null) repository.findByTag(tag, pageRequest) else repository.findAll(pageRequest)

    override fun tagBookmark(id: UUID, tag: String): Bookmark {
        val bookmark = getBookmark(id).addTag(Tag(tag))
        return repository.save(bookmark)
    }

    override fun deleteBookmark(id: UUID) = repository.deleteById(id)
}