package com.example.wtetsu.kotest.model

import java.time.LocalDateTime

class Item(var name: String, var gender: String) {
    var createdAt: LocalDateTime = LocalDateTime.MIN
}
