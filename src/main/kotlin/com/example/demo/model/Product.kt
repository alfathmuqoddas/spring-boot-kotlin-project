package com.example.demo.model

import jakarta.persistence.*
import com.example.demo.model.Category
import com.example.demo.model.SubCategory
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Entity
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

    @Column(nullable = false)
    val category_id: Long = 0,

    @Column(nullable = false)
    val subcategory_id: Long = 0,
)
