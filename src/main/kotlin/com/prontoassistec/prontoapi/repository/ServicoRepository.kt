package com.prontoassistec.prontoapi.repository

import com.prontoassistec.prontoapi.model.Servico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServicoRepository: JpaRepository<Servico, Long>