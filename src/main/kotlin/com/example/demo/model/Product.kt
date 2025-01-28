package com.example.demo.model

import jakarta.persistence.*
import com.example.demo.model.Category
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
    @field:NotBlank(message = "Product price cannot be blank")
    @field:Positive(message = "Product price cannot be negative")
    val price: Double = 0.0,

    @Column(nullable = false)
    @field:NotBlank(message = "Product quantity cannot be blank")
    @field:Positive(message = "Product quantity cannot be negative")
    val quantity: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("products")
    val category: Category? = null
) 
// {
//     // Explicit no-argument constructor for Hibernate
//     constructor() : this(0, "", 0.0, 0)
// }
