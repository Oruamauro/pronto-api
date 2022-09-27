package com.prontoassistec.prontoapi.controller

import com.prontoassistec.prontoapi.model.Produto
import com.prontoassistec.prontoapi.repository.ProdutoRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProdutoController(private val produtoRepository: ProdutoRepository) {

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna todos os produtos.")
    fun getAllProdutoss(): List<Produto> =
        produtoRepository.findAll()

    @PostMapping("/produtos")
    @ApiOperation(value = "Cadastra um produto.")
    fun createNewProduto(@Valid @RequestBody produto: Produto): Produto =
        produtoRepository.save(produto)

    @GetMapping("/produtos/{idProduto}")
    @ApiOperation(value = "Retorna um produto por id.")
    fun getProdutoById(@PathVariable(value = "idProduto") idProduto: Long): ResponseEntity<Produto> {
        return produtoRepository.findById(idProduto).map { produto ->
            ResponseEntity.ok(produto)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/produtos/{idProduto}")
    @ApiOperation(value = "Atualiza um produto por idProduto.")
    fun updateProdutoById(@PathVariable(value = "idProduto") idProduto: Long,
                          @Valid @RequestBody newProduto: Produto
    ): ResponseEntity<Produto> {

        return produtoRepository.findById(idProduto).map { existingProduto ->
            val updatedProduto: Produto = existingProduto
                .copy(prodNome = newProduto.prodNome, prodDesc = newProduto.prodDesc,
                    prodFornecedor = newProduto.prodFornecedor, prodValorCompra = newProduto.prodValorCompra,
                prodValor = newProduto.prodValor, prodQuant = newProduto.prodQuant)
            ResponseEntity.ok().body(produtoRepository.save(updatedProduto))
        }.orElse(ResponseEntity.notFound().build())
    }
    @DeleteMapping("/produtos/{idProduto}")
    @ApiOperation(value = "Exclui um produto por idProduto.")
    fun deleteProdutoById(@PathVariable(value = "idProduto") idProduto: Long): ResponseEntity<Void> {

        return produtoRepository.findById(idProduto).map { produto ->
            produtoRepository.delete(produto)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}