package com.example.demo.repository

import com.example.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Product, Long>