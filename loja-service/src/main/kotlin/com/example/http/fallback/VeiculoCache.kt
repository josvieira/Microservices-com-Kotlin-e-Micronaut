package com.example.http.fallback

import com.example.dto.output.Veiculo
import com.example.dto.output.VeiculoDto
import com.example.http.fallback.VeiculoHttp
import com.example.service.CachService
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.http.HttpResponse
import io.micronaut.retry.annotation.CircuitBreaker
import jakarta.inject.Singleton

/*
 * Fallback criado para quando a comunicação com o microservice de loja não funcionar
 * CircuitBreaker
 */

@Singleton
class VeiculoCache(
    private val objectMapper: ObjectMapper,
    private val cacheService: CachService,
    private val veiculoHttp: VeiculoHttp
) {

    fun findById(id: Long): VeiculoDto {
        println("veio no cache")
        var veiculoJson = cacheService.getData(id.toString())

        return if (veiculoJson != null)
            objectMapper.readValue(veiculoJson, VeiculoDto::class.java)
        else {

            val veiculoHttp = veiculoHttp.findById(id)

            cacheService.putData(
                id.toString(),
                objectMapper.writeValueAsString(veiculoHttp))

            veiculoHttp
        }

    }

    fun saveVeiculo(veiculo: Veiculo): HttpResponse<VeiculoDto> {
        TODO("Not yet implemented")
    }
}