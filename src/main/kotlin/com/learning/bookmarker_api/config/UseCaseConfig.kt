package com.learning.bookmarker_api.config

import com.learning.bookmarker_api.core.port.input.BookmarkUseCase
import com.learning.bookmarker_api.core.port.out.BookmarkRepository
import com.learning.bookmarker_api.core.port.out.EventPublisher

import com.learning.bookmarker_api.core.service.BookmarkService
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