package com.learning.bookmarker_api.adapter.`in`.rest

import com.learning.bookmarker_api.domain.model.Bookmark
import com.learning.bookmarker_api.domain.model.PageRequest
import com.learning.bookmarker_api.domain.port.input.BookmarkUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/api/v1/bookmarks")
class BookmarkController(
    private val useCase: BookmarkUseCase   // ← injects the PORT, not the service
) {
    @PostMapping
    fun create(@RequestBody req: BookmarkRequest): ResponseEntity<BookmarkResponse> {
        val bookmark = useCase.createBookmark(req.url, req.title, req.tags)
        return ResponseEntity.created(URI("/api/v1/bookmarks/${bookmark.id}"))
            .body(bookmark.toResponse())
    }

    @GetMapping
    fun list(
        @RequestParam tag: String? = null,
        @RequestParam page: Int = 1,
        @RequestParam size: Int = 10
    ): PaginatedResponse<BookmarkResponse> {
        val request = PageRequest(
            page = if (page < 1) 1 else page,
            size = size
        )
        val pageResult = useCase.listBookmarks(tag, request)
        return PaginatedResponse(
            data = pageResult.data.map { it.toResponse() },
            totalElements = pageResult.totalElements,
            totalPages = pageResult.totalPages,
            currentPage = pageResult.currentPage,
            isFirst = pageResult.isFirst,
            isLast = pageResult.isLast,
            hasNext = pageResult.hasNext,
            hasPrevious = pageResult.hasPrevious
        )
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID) = useCase.getBookmark(id).toResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) = useCase.deleteBookmark(id)

    // DTOs stay in the adapter — domain never knows about them
    private fun Bookmark.toResponse() = BookmarkResponse(
        id = id.toString(), url = url, title = title,
        tags = tags.map { it.name }, createdAt = createdAt.toString()
    )
}
