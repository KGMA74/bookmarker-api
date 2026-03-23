package com.learning.bookmarker_api.adapter.out.messaging

import com.learning.bookmarker_api.core.model.BookmarkCreatedEvent
import com.learning.bookmarker_api.core.port.out.EventPublisher
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

// For tests, swap it with a fake — domain service never changes
@Profile("dev", "test")
@Component
class InMemoryEventPublisher : EventPublisher {
    val published = mutableListOf<BookmarkCreatedEvent>()
    override fun publish(event: BookmarkCreatedEvent) { published.add(event) }
}