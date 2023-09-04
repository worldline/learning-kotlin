package com.worldline.training.restapispringkotlin.repository

import com.worldline.training.restapispringkotlin.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findAllByOrderByNameAsc(): List<Product>;
}