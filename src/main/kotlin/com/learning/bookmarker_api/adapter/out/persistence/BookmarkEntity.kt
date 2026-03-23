package com.learning.bookmarker_api.adapter.out.persistence

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "bookmarks")
class BookmarkEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val url: String,

    @Column(nullable = false)
    val title: String,

    // Liste de tags stockée dans une table séparée "bookmark_tags"
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "bookmark_tags",
        joinColumns = [JoinColumn(name = "bookmark_id")]
    )
    @Column(name = "tag")
    val tags: MutableList<String> = mutableListOf(),

    @Column(nullable = false)
    val createdAt: Instant = Instant.now()
    ) {
        // JPA a besoin d'un constructeur vide
        constructor() : this(url = "", title = "")
    }