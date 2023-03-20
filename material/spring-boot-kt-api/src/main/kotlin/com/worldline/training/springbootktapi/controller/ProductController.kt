package com.worldline.training.springbootktapi.controller

import com.worldline.training.springbootktapi.model.Product
import com.worldline.training.springbootktapi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(@Autowired val productRepository: ProductRepository) {
    @GetMapping fun getAll() = productRepository.findAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) = productRepository.findById(id)

    @PostMapping
    fun addOne(@RequestBody product: Product) {
        productRepository.save(product)
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: Long) {
        productRepository.deleteById(id)
    }
}