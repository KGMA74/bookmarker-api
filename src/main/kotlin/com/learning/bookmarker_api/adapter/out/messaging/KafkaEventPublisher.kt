package com.learning.bookmarker_api.adapter.out.messaging

import com.learning.bookmarker_api.domain.model.BookmarkCreatedEvent
import com.learning.bookmarker_api.domain.port.output.EventPublisher
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