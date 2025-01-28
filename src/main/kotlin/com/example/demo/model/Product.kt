package com.example.demo.model

import jakarta.persistence.*
import com.example.demo.model.Category

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val price: Double = 0.0,

    @Column(nullable = false)
    val quantity: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("products")
    val category: Category = Category()
) {
    // Explicit no-argument constructor for Hibernate
    constructor() : this(0, "", 0.0, 0)
}
