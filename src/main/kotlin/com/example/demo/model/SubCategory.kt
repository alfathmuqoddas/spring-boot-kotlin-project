package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import com.example.demo.model.Category

@Entity
data class SubCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "SubCategory name cannot be blank")
    val name: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category? = null
)
