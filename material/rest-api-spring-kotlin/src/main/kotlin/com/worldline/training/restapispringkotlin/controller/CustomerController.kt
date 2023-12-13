package com.worldline.training.restapispringkotlin.controller

import com.worldline.training.restapispringkotlin.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

val store = mutableListOf<Customer>()

@RestController
@RequestMapping("/customer")
class CustomerController {
    @GetMapping fun getAll() = store

    @GetMapping("{id}") fun getById(@PathVariable id: String) = store.firstOrNull { it.id == id }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addOne(@RequestBody customer: Customer) {
        store.add(customer)
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: String) {
        store.removeIf { it.id == id }
    }
}
