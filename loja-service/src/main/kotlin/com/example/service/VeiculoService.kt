package com.example.service

import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton

@Singleton
class VeiculoService(
    private val veiculoHttp: VeiculoHttp,
    private val objectMapper: ObjectMapper,
    private val cacheService: CachService
) {

    fun findById(id: Long): VeiculoDto {
        println("Buscando veículo...")
        val veiculo = veiculoHttp.findById(id)
        cacheService.putData(id.toString(), objectMapper.writeValueAsString(veiculo))//acho que isso deveria esta no serviço de veículo
        return veiculo
    }

}