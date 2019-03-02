package com.example


data class User (
    val name: String,
    val age: Int,
    val grade: String? = null
) : JsonSerializable

data class Car (
    val brand: String,
    val year: Int
) : JsonSerializable
