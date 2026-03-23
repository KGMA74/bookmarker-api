package com.learning.bookmarker_api


import com.learning.bookmarker_api.core.model.Bookmark
import com.learning.bookmarker_api.core.port.out.BookmarkRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

//@Component
class DataInitializer(
    private val bookmarkRepository: BookmarkRepository
): CommandLineRunner {
    override fun run(vararg args: String) {
        bookmarkRepository.save(Bookmark(title = "Google", url = "https://www.google.com"))
        bookmarkRepository.save(Bookmark(title = "Youtube", url = "https://www.youtube.com"))
        bookmarkRepository.save(Bookmark(title = "Github", url = "https://www.github.com"))
        bookmarkRepository.save(Bookmark(title = "Stackoverflow", url = "https://www.stackoverflow.com"))
        bookmarkRepository.save(Bookmark(title = "Linkedin", url = "https://www.linkedin.com"))
        bookmarkRepository.save(Bookmark(title = "Twitter", url = "https://www.twitter.com"))
        bookmarkRepository.save(Bookmark(title = "Facebook", url = "https://www.facebook.com"))
    }
}