package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

import com.example.demo.model.Category

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
data class SubCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "SubCategory name cannot be blank")
    val name: String = "",

    @Column(nullable = false)
    val categoryId: Long = 0,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var updatedDate: LocalDateTime? = null,
)
