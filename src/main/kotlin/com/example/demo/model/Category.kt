package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "Category name cannot be blank")
    val name: String = "",

)