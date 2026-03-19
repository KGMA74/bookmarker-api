package com.learning.bookmarker_api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant


@Entity
@Table(name = "bookmark")
class Bookmark (
    @Id
    @SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var url: String,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: Instant? = Instant.now()
)