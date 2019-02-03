package com.example.wtetsu.kotest.db

import com.example.wtetsu.kotest.model.Item
import com.google.common.cache.Cache
import java.util.concurrent.TimeUnit
import com.google.common.cache.CacheBuilder
import org.ajbrown.namemachine.NameGenerator
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class InMemoryDb {
    private var currentIndex: Int = -1
    private val cache: Cache<Int, Item> = createCache()

    private fun createCache(): Cache<Int, Item> {
        val newCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(300, TimeUnit.MINUTES)
                .build<Int, Item>()

        val nameGenerator = NameGenerator();

        for (i in 0..4) {
            val newName = nameGenerator.generateName()
            val newItem = Item(newName.firstName + " " + newName.lastName, newName.gender.toString())
            newItem.createdAt = LocalDateTime.now()
            newCache.put(i, newItem)
        }

        currentIndex = 4

        return newCache
    }

    fun add(newItem: Item) {
        val newIndex = currentIndex + 1
        cache.put(newIndex, newItem)
        currentIndex = newIndex
    }

    fun find(id: Int): Item? {
        return cache.getIfPresent(id)
    }

    fun list(): List<Item> {
        val resultList: MutableList<Item> = ArrayList<Item>()
        for(i in 0..currentIndex) {
            val item : Item? = cache.getIfPresent(i)
            if (item != null) {
                resultList.add(item)
            }
        }
        return resultList
    }
}
