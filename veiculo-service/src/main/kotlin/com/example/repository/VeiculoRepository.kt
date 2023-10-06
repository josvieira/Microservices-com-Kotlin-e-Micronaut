package com.example.repository

import com.example.model.Veiculo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.Optional

@Repository
interface VeiculoRepository: JpaRepository<Veiculo, Long> {

    fun findByPlaca(placa: String): Optional<Veiculo>
}