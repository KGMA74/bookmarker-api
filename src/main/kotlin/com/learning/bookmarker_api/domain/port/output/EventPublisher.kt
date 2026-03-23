package com.learning.bookmarker_api.domain.port.output

import com.learning.bookmarker_api.domain.model.BookmarkCreatedEvent

interface EventPublisher {
    fun publish(event: BookmarkCreatedEvent)
}