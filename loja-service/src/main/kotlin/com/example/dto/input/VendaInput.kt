package com.example.dto.input

import java.math.BigDecimal

data class VendaInput(
    val cliente: String,
    val placaVeiculo: String,
    val valor: BigDecimal,
    val quantidadeParcelas: Int
)
