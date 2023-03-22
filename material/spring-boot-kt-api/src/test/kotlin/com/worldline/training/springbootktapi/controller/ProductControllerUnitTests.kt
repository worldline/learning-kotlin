package com.worldline.training.springbootktapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.worldline.training.springbootktapi.model.Product
import com.worldline.training.springbootktapi.repository.ProductRepository
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerUnitTests(@Autowired val mockMvc: MockMvc,
                                 @Autowired val objectMapper: ObjectMapper,
                                 @Autowired val productRepository: ProductRepository) {

    @BeforeEach
    fun reset(){
        productRepository.deleteAll()
    }

    @Test
    fun testWithClassicApproach(){
        mockMvc.perform(get("/product"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("[]")))
    }

    @Test
    fun `test POST a single product`() {

        mockMvc.post("/product") {
            content = """{ "name":"A", "price": 1 }"""
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated() }
        }

        mockMvc.get("/product/1").andExpect {
            status { isOk() }
            jsonPath("$.name") { value("A") }
            jsonPath("$.price") { value(1) }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }
}