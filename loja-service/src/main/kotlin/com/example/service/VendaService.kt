package com.example.service

import com.example.dto.input.VendaInput
import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import jakarta.inject.Singleton

@Singleton
class VendaService(
    private val http: VeiculoHttp
) {

    fun realizarVenda(vendaInput: VendaInput): VeiculoDto = http.findById(vendaInput.veiculo)
}