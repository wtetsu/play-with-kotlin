package com.example.wtetsu.kotest.db

import com.example.wtetsu.kotest.model.Item
import org.junit.Assert.*
import org.junit.Test

class InMemoryDbTest {
    @Test
    fun basicTest() {

        val db = InMemoryDb();
        val initialSize = db.list().size;

        db.add(Item("Name0", "Gender0"))
        db.add(Item("Name1", "Gender1"))
        db.add(Item("Name2", "Gender2"))

        assertEquals(initialSize + 3, db.list().size)
    }
}