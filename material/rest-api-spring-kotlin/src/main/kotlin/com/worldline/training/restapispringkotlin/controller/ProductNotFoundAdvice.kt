package com.worldline.training.restapispringkotlin.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

internal class ProductNotFoundException(): Exception()

@ControllerAdvice
internal class ProductControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ProductNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(ex: ProductNotFoundException) = ex.message
}



