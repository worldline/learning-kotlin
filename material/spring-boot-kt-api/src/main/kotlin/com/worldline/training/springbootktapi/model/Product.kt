package com.worldline.training.springbootktapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity class Product(@Id @GeneratedValue var id: Long? = null, var name: String, var price: Int)