package com.worldline.training.springbootktapi.controller

import com.worldline.training.springbootktapi.model.Product
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `test POST a single product`() {
        val result = restTemplate.postForEntity("/product", Product(null, "A", 1), Product::class.java)
        assertEquals(HttpStatus.CREATED, result?.statusCode)

        val productResult = restTemplate.getForEntity("/product/1", Product::class.java)
        assertEquals("A", productResult.body?.name)
        assertEquals(1, productResult.body?.price)
    }
}