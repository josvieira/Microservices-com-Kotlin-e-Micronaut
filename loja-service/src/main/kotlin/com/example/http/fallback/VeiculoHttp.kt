package com.example.http.fallback

import com.example.dto.output.Veiculo
import com.example.dto.output.VeiculoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Fallback

@Client(id = "http://localhost:8080")
interface VeiculoHttp {
    //Acho que aqui eu poderia inverter, colocar essas chamadas ao serviço externo no fallback caso não ache nada no cache

    @Get("/veiculos/{id}")
    fun findByPlaca(@PathVariable placa: String):VeiculoDto

    @Post("/veiculos")
    fun saveVeiculo(@Body veiculo: Veiculo): HttpResponse<VeiculoDto>
}