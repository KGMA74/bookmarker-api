package com.learning.bookmarker_api.core.exception

import java.util.UUID

class BookmarkNotFoundException(id: UUID)
    : RuntimeException("Bookmark not found with id: $id")