package com.worldline.training.springbootktapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.worldline.training.springbootktapi.model.Product
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerTests(@Autowired val mockMvc: MockMvc,
                             @Autowired val objectMapper: ObjectMapper) {

    @Test
    fun testWithClassicApproach(){
        mockMvc.perform(get("/product"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("[]")))
    }

    @Test
    fun `test POST a single product`() {
        val p = Product(null, "A", 1)
        mockMvc.post("/product") {
            content = objectMapper.writeValueAsString(p)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated() }
            jsonPath("$.name") { value("name") }
            jsonPath("$.price") { value(1) }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }
}