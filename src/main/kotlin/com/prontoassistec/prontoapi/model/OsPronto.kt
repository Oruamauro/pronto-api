package com.prontoassistec.prontoapi.model
import io.swagger.annotations.ApiOperation
import javax.persistence.*

@Entity
data class OsPronto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:ApiOperation(value = "Modelo de ordem de serviços.")
    val idOS: Long = 0,

    @ManyToOne
    val idCliente: Cliente,
    //@ManyToOne
    //val cliente: Cliente,

    val dataInicio: String,

    val dataFim: String,

    val marcaModelo: String,

    val problema: String,

    val observacoes: String,

    @ManyToOne
    val servico: Servico,

    @ManyToOne
    val produto: Produto,

    @Enumerated(EnumType.ORDINAL)
    val status: Status,

    val total: String
)