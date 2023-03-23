package com.worldline.training.springbootktapi.controller

import com.worldline.training.springbootktapi.model.Product
import com.worldline.training.springbootktapi.repository.ProductRepository
import com.worldline.training.springbootktapi.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/product")
class ProductController(@Autowired val productService: ProductService) {

    @GetMapping fun getAll() = productService.getAll()


//      Longer version
//      fun getById(@PathVariable id: Long): Product {
//              val product = productService.getById(id)
//              if (product != null){
//                  return product
//              }
//              throw ResponseStatusException(HttpStatus.NOT_FOUND)
//    }
    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) =
        productService.getById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addOne(@RequestBody product: Product) {
        productService.addOne(product)
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: Long) {
        if (!productService.deleteOne(id)){
            throw ProductNotFoundException()
        }
    }
}

