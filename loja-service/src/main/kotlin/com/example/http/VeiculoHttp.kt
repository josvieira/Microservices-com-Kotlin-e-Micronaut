package com.example.http

import com.example.dto.output.Veiculo
import com.example.dto.output.VeiculoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client(id = "http://localhost:8080")
@CircuitBreaker //funcionou mesmo sem essa anotation porque?
interface VeiculoHttp {
    //Acho que aqui eu poderia inverter, colocar essas chamadas ao serviço externo no fallback caso não ache nada no cache

    @Get("/veiculos/{id}")
    fun findById(@PathVariable id: Long):VeiculoDto

    @Post("/veiculos")
    fun saveVeiculo(@Body veiculo: Veiculo): HttpResponse<VeiculoDto>
}