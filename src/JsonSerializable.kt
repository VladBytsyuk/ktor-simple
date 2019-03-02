package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


interface JsonSerializable {

    fun toJson(): String = jsonMapper.writeValueAsString(this)

    companion object {
        val jsonMapper = ObjectMapper().registerKotlinModule()

        inline fun <reified T : JsonSerializable> fromJson(json: String): T = jsonMapper.readValue(json)
    }
}
