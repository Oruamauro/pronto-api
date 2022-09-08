package com.prontoassistec.prontoapi.repository

import com.prontoassistec.prontoapi.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository <Cliente, Long>