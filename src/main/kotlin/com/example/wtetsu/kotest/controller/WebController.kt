package com.example.wtetsu.kotest.controller;

import com.example.wtetsu.kotest.db.InMemoryDb
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("web")
class WebController {
    @Autowired
    lateinit var db: InMemoryDb

    @GetMapping("items")
    fun items(model: Model): String {
        model.addAttribute("items", db.list())
        return "items"
    }
}

