package com.prontoassistec.prontoapi.controller

import com.prontoassistec.prontoapi.model.Servico
import com.prontoassistec.prontoapi.repository.ServicoRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class ServicoController(private val servicoRepository: Repository) {

    @RestController
    @RequestMapping("/")
    class ServicoController (private val servicoRepository: ServicoRepository){

        @GetMapping("/servicos")
        @ApiOperation(value = "Retorna todos os serviços.")
        fun getAllClientes(): List<Servico> =
            servicoRepository.findAll()

        @PostMapping("/servicos")
        @ApiOperation(value = "Cadastra um serviço.")
        fun createNewServico(@Valid @RequestBody servico: Servico): Servico =
            servicoRepository.save(servico)

        @GetMapping("/servicos/{id}")
        @ApiOperation(value = "Retorna um serviço por idServico.")
        fun getServicoById(@PathVariable(value = "id") idServico: Long): ResponseEntity<Servico> {
            return servicoRepository.findById(idServico).map { servico ->
                ResponseEntity.ok(servico)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PutMapping("/servicos/{id}")
        @ApiOperation(value = "Atualiza um serviço.")
        fun updateServicoById(@PathVariable(value = "id") idServico: Long,
                              @Valid @RequestBody newServico: Servico
        ): ResponseEntity<Servico> {

            return servicoRepository.findById(idServico).map { existingServico ->
                val updatedServico: Servico = existingServico
                    .copy(descServico = newServico.descServico, precoServico = newServico.precoServico)
                ResponseEntity.ok().body(servicoRepository.save(updatedServico))
            }.orElse(ResponseEntity.notFound().build())
        }
        @DeleteMapping("/serviços/{id}")
        @ApiOperation(value = "Exclui um serviço por idServico.")
        fun deleteById(@PathVariable(value = "id") idServico: Long): ResponseEntity<Void> {

            return servicoRepository.findById(idServico).map { servico ->
                servicoRepository.delete(servico)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }

    }
}