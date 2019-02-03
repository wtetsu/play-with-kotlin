package com.example.wtetsu.kotest.controller

import com.example.wtetsu.kotest.db.InMemoryDb
import com.example.wtetsu.kotest.model.Item
import com.example.wtetsu.kotest.model.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class ApiController {
    @Autowired
    lateinit var db: InMemoryDb

    @GetMapping("/add")
    @ResponseBody
    fun add(
            @RequestParam(value = "name", required = true) name: String,
            @RequestParam(value = "gender", required = false, defaultValue = "") gender: String
    ): Result {
        val newItem = Item(name, gender)
        newItem.createdAt = LocalDateTime.now()
        db.add(newItem)
        return Result(0)
    }

    @GetMapping("/list")
    @ResponseBody
    fun list(): List<Item> {
        return db.list()
    }
}
