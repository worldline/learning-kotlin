package com.worldline.training.springbootktapi.service

import com.worldline.training.springbootktapi.model.Product
import com.worldline.training.springbootktapi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class ProductService(@Autowired val productRepository: ProductRepository) {
    fun getAll() = productRepository.findAllByOrderByNameAsc()

    // use findByIdOrNull instad of findById because the latter returns an optional<Product> instead of Product?
    fun getById(id: Long) = productRepository.findByIdOrNull(id)

    fun addOne(product: Product) {
        productRepository.save(product)
    }

    fun deleteOne(id: Long): Boolean {
        if (productRepository.findByIdOrNull(id) == null){
            return false
        }
        productRepository.deleteById(id)
        return true
    }
}