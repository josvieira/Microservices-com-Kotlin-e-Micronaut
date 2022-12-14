package com.example.http

import com.example.dto.output.VeiculoDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client(id = "http://localhost:8080")
//@CircuitBreaker //funcionou mesmo sem essa anotation porque?
interface VeiculoHttp {

    @Get("/veiculos/{id}")
    fun findById(@PathVariable id: Long): VeiculoDto
}