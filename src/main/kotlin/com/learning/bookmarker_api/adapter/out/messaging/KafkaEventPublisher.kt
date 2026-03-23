package com.learning.bookmarker_api.adapter.out.messaging

import com.learning.bookmarker_api.core.model.BookmarkCreatedEvent
import com.learning.bookmarker_api.core.port.out.EventPublisher
import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


@Profile("prod")
@Component
class KafkaEventPublisher (
    private val kafkaTemplate: KafkaTemplate<String, String>
): EventPublisher {
    override fun publish(event: BookmarkCreatedEvent) {
        kafkaTemplate.send("bookmark-created", event.bookmarkId, event.url)
    }
}