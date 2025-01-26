package com.example.demo.model

import jakarta.persistence.*

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
    val quantity: Int = 0
) {
    // Explicit no-argument constructor for Hibernate
    constructor() : this(0, "", 0.0, 0)
}
