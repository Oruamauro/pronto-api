package com.prontoassistec.prontoapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idProduto: Long = 0,

    @get:NotNull
    val prodNome: String,
    val prodDesc: String,
    val prodFornecedor: String,
    val prodValorCompra: String,
    val prodValor: String,
    val prodQuant: String
)