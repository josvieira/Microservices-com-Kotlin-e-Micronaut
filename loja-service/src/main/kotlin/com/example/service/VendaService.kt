package com.example.service

import com.example.dto.input.VendaInput
import com.example.producer.VendaProducer
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton

@Singleton
class VendaService(
    private val http: VeiculoService,
    private val kafka: VendaProducer,
    private val objectMapper: ObjectMapper
) {

    fun realizarVenda(vendaInput: VendaInput): VendaInput{
        val veiculo = http.findById(vendaInput.veiculo)
        return vendaInput
    }
}