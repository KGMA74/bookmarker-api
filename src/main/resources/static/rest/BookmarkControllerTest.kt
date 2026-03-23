//package com.learning.bookmarker_api.adapter.`in`.rest
//
//import com.learning.bookmarker_api.core.model.Bookmark
//import com.learning.bookmarker_api.core.port.out.BookmarkRepository
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.params.ParameterizedTest
//import org.junit.jupiter.params.provider.CsvSource
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection
//import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.test.context.TestConstructor
//import org.springframework.test.web.servlet.MockMvc
//import org.testcontainers.containers.PostgreSQLContainer
//import org.testcontainers.junit.jupiter.Container
//import org.testcontainers.junit.jupiter.Testcontainers
//
//
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@AutoConfigureMockMvc
////@ActiveProfiles("test")
////@Testcontainers // Automatically starts/stops containers
////@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//class BookmarkControllerTest(
//    private val mvc: MockMvc,
//    private val bookmarkRepository: BookmarkRepository
//) {
//    companion object {
////        @JvmStatic
//        @Container
//        @ServiceConnection // Automatically configures spring.datasource properties
//        val postgres = PostgreSQLContainer("postgres:17-alpine")
//    }
//
//    @BeforeEach
//    fun setUp() {
//        bookmarkRepository.deleteAllInBatch()
//        val bookmarks = listOf(
//            Bookmark(title = "Google", url = "https://www.google.com"),
//            Bookmark(title = "Youtube", url = "https://www.youtube.com"),
//            Bookmark(title = "Github", url = "https://www.github.com"),
//            Bookmark(title = "Stackoverflow", url = "https://www.stackoverflow"),
//            Bookmark(title = "Linkedin", url = "https://www.linkedin.com"),
//            Bookmark(title = "Twitter", url = "https://www.twitter.com"),
//            Bookmark(title = "Facebook", url = "https://www.facebook.com"),
//            Bookmark(title = "Instagram", url = "https://www.instagram.com"),
//            Bookmark(title = "Reddit", url = "https://www.reddit.com")
//        )
//        bookmarkRepository.saveAll(bookmarks)
//    }
//
//    @ParameterizedTest
//    @CsvSource(
//        value = [
//            "1,5,5,2,1,true,false,true,false",
//            "2,5,4,2,2,false,true,false,true"
//        ]
//    )
//    fun should_get_all_bookmarks(
//        page: Int, size: Int, totalElements: Int, totalPages: Int,
//        currentPage: Int, isFirst: Boolean, isLast: Boolean,
//        hasNext: Boolean, hasPrevious: Boolean
//    ) {
//        //        mvc.perform(get("/api/v1/bookmarks?page=$page&size=$size"))
//        //            .andExpect(status().isOk)
//        //            .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
//        //            .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
//        //            .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
//        //            .andExpect(jsonPath("$.isFcontextLoadsirst", CoreMatchers.equalTo(isFirst)))
//        //            .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
//        //            .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
//        //            .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)))
//    }
//}