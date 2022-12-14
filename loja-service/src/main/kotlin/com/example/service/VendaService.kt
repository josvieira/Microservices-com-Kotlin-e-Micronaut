package com.example.service

import com.example.dto.input.VendaInput
import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import com.example.producer.VendaProducer
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import java.util.*

@Singleton
class VendaService(
    private val http: VeiculoService,
    private val kafka: VendaProducer,
    private val objectMapper: ObjectMapper
) {

    fun realizarVenda(vendaInput: VendaInput): VendaInput{
        val veiculo = http.findById(vendaInput.veiculo)
        confirmarVenda(vendaInput)
        return vendaInput
    }

    fun confirmarVenda(venda: VendaInput){
        val vendaJson = objectMapper.writeValueAsString(venda)
        kafka.publicarVenda(UUID.randomUUID().toString(), vendaJson)
    }
}