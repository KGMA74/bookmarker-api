package com.learning.bookmarker_api.domain.port.output

interface DatabasePort {
    fun getAllBookmarks(id: Long)
}