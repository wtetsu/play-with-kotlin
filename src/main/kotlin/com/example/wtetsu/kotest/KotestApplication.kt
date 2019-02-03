package com.example.wtetsu.kotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class KotestApplication {
    @GetMapping("/hello")
    fun hello() = "hello!!!!!!!"
}

fun main(args: Array<String>) {
    runApplication<KotestApplication>(*args)
}

