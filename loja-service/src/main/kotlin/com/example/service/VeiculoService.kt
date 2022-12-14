package com.example.service

import com.example.dto.output.VeiculoDto
import com.example.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Singleton
class VeiculoService(
    private val veiculoHttp: VeiculoHttp,
    private val objectMapper: ObjectMapper
) {

    fun findById(id: Long): VeiculoDto {
        val veiculo = veiculoHttp.findById(id)
        gravarCache(veiculo)
        return veiculo
    }

    fun gravarCache(veiculo: VeiculoDto){
        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)
        val jedis = jedisPool.resource
        var veiculoJson = objectMapper.writeValueAsString(veiculo)
        jedis.set(veiculo.id.toString(), veiculoJson)
    }
}