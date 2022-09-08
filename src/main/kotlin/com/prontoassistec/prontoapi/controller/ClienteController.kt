package com.prontoassistec.prontoapi.controller

import com.prontoassistec.prontoapi.model.Cliente
import com.prontoassistec.prontoapi.repository.ClienteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/pronto-api")
class ClienteController (private val clienteRepository: ClienteRepository){

    @GetMapping("/clientes")
    fun getAllClientes(): List<Cliente> =
        clienteRepository.findAll()

    @PostMapping("/clientes")
    fun createNewCliente(@Valid @RequestBody cliente: Cliente): Cliente =
        clienteRepository.save(cliente)

    @GetMapping("/clientes/{id}")
    fun getClienteById(@PathVariable(value = "id") clienteId: Long): ResponseEntity<Cliente>{
        return clienteRepository.findById(clienteId).map { cliente ->
            ResponseEntity.ok(cliente)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/clientes/{id}")
    fun updateClienteById(@PathVariable(value = "id") clienteId: Long,
                          @Valid @RequestBody newCliente: Cliente): ResponseEntity<Cliente> {

        return clienteRepository.findById(clienteId).map { existingCliente ->
            val updatedArticle: Cliente = existingCliente
                .copy(nome = newCliente.nome, email = newCliente.email, cel = newCliente.cel)
            ResponseEntity.ok().body(clienteRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())
    }
    @DeleteMapping("/clientes/{id}")
    fun deleteById(@PathVariable(value = "id") clienteId: Long): ResponseEntity<Void> {

        return clienteRepository.findById(clienteId).map { cliente ->
            clienteRepository.delete(cliente)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}