package com.worldline.training.springbootktapi.repository

import com.worldline.training.springbootktapi.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findAllByOrderByNameAsc(): List<Product>;
}