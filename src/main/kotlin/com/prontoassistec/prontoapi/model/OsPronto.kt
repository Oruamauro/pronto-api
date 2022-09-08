package com.prontoassistec.prontoapi.model
import java.util.Objects
import java.util.Optional
import javax.persistence.*
import javax.persistence.EnumType.ORDINAL
import javax.persistence.EnumType.STRING

@Entity
data class OsPronto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idOS: Long = 0,

    @OneToOne
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