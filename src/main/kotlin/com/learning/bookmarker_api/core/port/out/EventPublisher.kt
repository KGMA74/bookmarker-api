package com.learning.bookmarker_api.core.port.out

import com.learning.bookmarker_api.core.model.BookmarkCreatedEvent

interface EventPublisher {
    fun publish(event: BookmarkCreatedEvent)
}