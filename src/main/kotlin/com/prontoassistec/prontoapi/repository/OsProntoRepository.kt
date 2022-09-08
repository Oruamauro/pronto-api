package com.prontoassistec.prontoapi.repository

import com.prontoassistec.prontoapi.model.OsPronto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OsProntoRepository: JpaRepository<OsPronto, Long>