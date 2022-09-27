package com.prontoassistec.prontoapi.model

import io.swagger.annotations.ApiOperation
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@ApiOperation(value = "Modelo de serviço.")
data class Servico (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idServico: Long = 0,
    @NotBlank
    @NotNull
    val descServico: String = "",
    @NotBlank
    @NotNull
    val precoServico: String = ""
        )