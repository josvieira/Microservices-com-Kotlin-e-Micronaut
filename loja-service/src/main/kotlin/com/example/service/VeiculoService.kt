package com.example.service

import com.example.dto.output.VeiculoDto
import com.example.http.fallback.VeiculoCache
import jakarta.inject.Singleton

@Singleton
class VeiculoService(
    private val veiculoCache: VeiculoCache
) {

    fun findById(id: Long): VeiculoDto {
        println("Buscando veículo...")
        val veiculo = veiculoCache.findById(id)
        return veiculo
    }

}