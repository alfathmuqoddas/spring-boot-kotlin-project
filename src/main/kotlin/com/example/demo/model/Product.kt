package com.example.demo.model

import jakarta.persistence.*

import com.example.demo.model.Category
import com.example.demo.model.SubCategory

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "Product name cannot be blank")
    val name: String = "",

    @Column(nullable = false)
    @field:Positive(message = "Product price cannot be negative")
    val price: Double = 0.0,

    @Column(nullable = false)
    @field:Positive(message = "Product quantity cannot be negative")
    val quantity: Int = 0,

    @Column(name="category_id", nullable = false)
    val categoryId: Long = 0,

    @Column(name="subcategory_id", nullable = false)
    val subcategoryId: Long = 0,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var updatedDate: LocalDateTime? = null,
)
