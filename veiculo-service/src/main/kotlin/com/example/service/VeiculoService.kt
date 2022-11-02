package com.example.service

import com.example.model.Veiculo
import com.example.repository.VeiculoRepository
import jakarta.inject.Singleton
import java.util.Optional

/*
 *No caso desse projeto será mesmo que ue precisaria ter essa classe de serviço?
 * Será que essas funções não poderiam estar dentro da classe veículo?
 * Ou mesmo a controller chamar diretamente o repository visto que não possu nenhuma regra especial aqui?
 */
@Singleton
class VeiculoService(private val repository: VeiculoRepository) {

    fun create(veiculo: Veiculo): Veiculo = repository.save(veiculo)

    fun findById(id: Long): Optional<Veiculo> = repository.findById(id)
}