package com.example.demo.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.validation.constraints.NotBlank
import com.example.demo.model.Product

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "Category name cannot be blank")
    val name: String = "",

    // @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL])
    // @JsonIgnoreProperties("category")
    // val products: List<Product> = mutableListOf()
)