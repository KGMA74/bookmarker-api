package com.learning.bookmarker_api.domain.model

data class BookmarkCreatedEvent(val bookmarkId: String, val url: String)