package com.prontoassistec.prontoapi.controller

import com.prontoassistec.prontoapi.model.OsPronto
import com.prontoassistec.prontoapi.repository.OsProntoRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/")
class OsProntoController (private val osProntoRepository: OsProntoRepository){

        @GetMapping("/os")
        @ApiOperation(value = "Retorna todas ordens de serviços.")
        fun getAllOs(): List<OsPronto> =
            osProntoRepository.findAll()

        @PostMapping("/os")
        @ApiOperation(value = "Abre uma ordem de serviço.")
        fun createNewOs(@Valid @RequestBody osPronto: OsPronto): OsPronto =
            osProntoRepository.save(osPronto)

        @GetMapping("/os/{id}")
        @ApiOperation(value = "Retorna uma ordem de serviço por idOS.")
        fun getOsById(@PathVariable(value = "id") idOS: Long): ResponseEntity<OsPronto> {
            return osProntoRepository.findById(idOS).map { osPronto ->
                ResponseEntity.ok(osPronto)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PutMapping("/os/{id}")
        @ApiOperation(value = "Atualiza uma ordem de serviço.")
        fun updateOsById(@PathVariable(value = "id") idOS: Long,
                              @Valid @RequestBody newOsPronto: OsPronto
        ): ResponseEntity<OsPronto> {

            return osProntoRepository.findById(idOS).map { existingOs ->
                val updatedOs: OsPronto = existingOs
                    .copy(idCliente = newOsPronto.idCliente, dataInicio = newOsPronto.dataInicio,
                        dataFim = newOsPronto.dataFim, marcaModelo = newOsPronto.marcaModelo,
                        problema = newOsPronto.problema, observacoes = newOsPronto.observacoes,
                        servico = newOsPronto.servico, produto = newOsPronto.produto,
                        status = newOsPronto.status, total = newOsPronto.total)
                ResponseEntity.ok().body(osProntoRepository.save(updatedOs))
            }.orElse(ResponseEntity.notFound().build())
        }
        @DeleteMapping("/os/{id}")
        @ApiOperation(value = "Exclui uma ordem de serviço por idOS.")
        fun deleteOsById(@PathVariable(value = "id") idOS: Long): ResponseEntity<Void> {

            return osProntoRepository.findById(idOS).map { cliente ->
                osProntoRepository.delete(cliente)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }
}