package com.prontoassistec.prontoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class ProntoApiApplication

fun main(args: Array<String>) {
	runApplication<ProntoApiApplication>(*args)
}