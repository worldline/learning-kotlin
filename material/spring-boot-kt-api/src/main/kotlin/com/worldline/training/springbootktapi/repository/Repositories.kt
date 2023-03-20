package com.worldline.training.springbootktapi.repository

import com.worldline.training.springbootktapi.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long>