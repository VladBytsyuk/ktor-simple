package com.example

import kotlin.test.*
import io.ktor.http.*
import io.ktor.server.testing.*


class EndPointsTest {
    private fun testEndpoint(
        endPoint: String,
        expectedObject: JsonSerializable? = null
    ) {
        withTestApplication(moduleFunction = { module(testing = true) }) {
            handleRequest(HttpMethod.Get, endPoint).apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                assertEquals(expected = expectedObject?.toJson() ?: "", actual = response.content)
            }
        }
    }


    @Test
    fun testRoot() = testEndpoint(
        endPoint = EndPoints.ROOT
    )

    @Test
    fun testUser() = testEndpoint(
        endPoint = EndPoints.USER,
        expectedObject = User(name = "Empty", age = 0, grade = "-")
    )

    @Test
    fun testUserAlice() = testEndpoint(
        endPoint = EndPoints.User.ALICE,
        expectedObject = User(name = "Alice", age = 18, grade = "B")
    )

    @Test
    fun testUserBob() = testEndpoint(
        endPoint = EndPoints.User.BOB,
        expectedObject = User(name = "Bob", age = 42, grade = "D")
    )

    @Test
    fun testCar() = testEndpoint(
        endPoint = EndPoints.CAR,
        expectedObject = Car(brand = "Ford", year = 1995)
    )
}
