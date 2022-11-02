package com.example.service

import com.example.dto.input.VendaInput
import com.example.http.VeiculoHttp
import jakarta.inject.Singleton

@Singleton
class VendaService(
    private val http: VeiculoHttp
) {

    fun realizarVenda(vendaInput: VendaInput){
        val veiculo = http.findById(vendaInput.veiculo)
        println(veiculo)
    }
}