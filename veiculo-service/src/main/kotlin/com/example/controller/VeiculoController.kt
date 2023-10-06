package com.example.controller

import com.example.model.Veiculo
import com.example.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("veiculos")
class VeiculoController(
    private val service: VeiculoService
) {

    @Post
    fun create(@Body veiculo: Veiculo): HttpResponse<Veiculo> {
        return HttpResponse.created(service.create(veiculo))
    }

    @Get("/{id}")
    fun findByPlaca(@PathVariable placa: String): HttpResponse<Veiculo> {
        return HttpResponse.ok(service.findByPlaca(placa).get())
    }
}