package com.worldline.training.springbootktapi.model

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Product(@Id @GeneratedValue var id: Long? = null, var name: String, var price: Int)