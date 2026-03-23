package com.learning.bookmarker_api.config

import com.learning.bookmarker_api.domain.port.input.BookmarkUseCase
import com.learning.bookmarker_api.domain.port.output.BookmarkRepository
import com.learning.bookmarker_api.domain.port.output.EventPublisher

import com.learning.bookmarker_api.domain.service.BookmarkService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    fun BookmarkUseCase(
        repository: BookmarkRepository,
        eventPublisher: EventPublisher
    ): BookmarkUseCase = BookmarkService(repository, eventPublisher)
}