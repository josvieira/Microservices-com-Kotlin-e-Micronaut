package com.example.service

import io.lettuce.core.api.StatefulRedisConnection
import jakarta.inject.Singleton

@Singleton
class CacheService(
    private val conection: StatefulRedisConnection<String, String>
) {

    fun putData(key: String, value: String){
        val conect = conection.sync()
        conect[key] = value
    }
}