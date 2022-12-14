package com.example.http.fallback

import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.retry.annotation.Fallback
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

/*
 * Fallback criado para quando a comunicação com o microservice de loja não funcionar
 * CircuitBreaker
 */
@Fallback
class VeiculoHttpFallback(
    private val objectMapper: ObjectMapper
): VeiculoHttp {

    override fun findById(id: Long): VeiculoDto {
        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)
        var jedis = jedisPool.resource
        val veiculoJson = jedis.get(id.toString())
        val veiculo = objectMapper.readValue(veiculoJson, VeiculoDto::class.java)
        print("veio no circuitbreaker")
        return veiculo
    }
}