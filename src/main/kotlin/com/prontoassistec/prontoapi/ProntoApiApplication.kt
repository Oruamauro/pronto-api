package com.prontoassistec.prontoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProntoApiApplication

fun main(args: Array<String>) {
	runApplication<ProntoApiApplication>(*args)
}