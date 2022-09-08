package com.prontoassistec.prontoapi.repository

import com.prontoassistec.prontoapi.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository: JpaRepository<Produto, Long>