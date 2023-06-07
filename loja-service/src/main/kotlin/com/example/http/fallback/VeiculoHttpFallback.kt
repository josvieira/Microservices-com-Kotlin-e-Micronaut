package com.example.http.fallback

import com.example.dto.output.Veiculo
import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import com.example.service.CachService
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.http.HttpResponse
import io.micronaut.retry.annotation.Fallback
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

/*
 * Fallback criado para quando a comunicação com o microservice de loja não funcionar
 * CircuitBreaker
 */
@Fallback
class VeiculoHttpFallback(
    private val objectMapper: ObjectMapper,
    private val cacheService: CachService
): VeiculoHttp {

    override fun findById(id: Long): VeiculoDto {
        println("veio no circuitbreaker")
        val veiculoJson = cacheService.getData(id.toString())
        return objectMapper.readValue(veiculoJson, VeiculoDto::class.java)
    }

    override fun saveVeiculo(veiculo: Veiculo): HttpResponse<VeiculoDto> {
        TODO("Not yet implemented")
    }
}