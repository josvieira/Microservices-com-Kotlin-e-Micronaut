package com.example.controller

import com.example.dto.input.VendaInput
import com.example.service.VendaService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vendas")
class VendaController(
    private val service: VendaService
) {

    @Post
    fun realizarVenda(@Body vendaInput: VendaInput){
        service.realizarVenda(vendaInput)
    }
}