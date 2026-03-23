package com.learning.bookmarker_api.core.port.out

interface DatabasePort {
    fun getAllBookmarks(id: Long)
}