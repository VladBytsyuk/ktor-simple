package com.example

import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


@Suppress("unused") // Referenced in application.conf
fun Application.module(testing: Boolean = false) = routing {

    get(EndPoints.ROOT) { call.respondText(text = "", contentType = ContentType.Text.Plain) }

    get(EndPoints.USER) { call.respondJson(User(name = "Empty", age = 0, grade = "-")) }
    get(EndPoints.User.ALICE) { call.respondJson(User(name = "Alice", age = 18, grade = "B")) }
    get(EndPoints.User.BOB) { call.respondJson(User(name = "Bob", age = 42, grade = "D")) }

    get(EndPoints.CAR) { call.respondJson(Car(brand = "Ford", year = 1995)) }
}

suspend fun ApplicationCall.respondJson(obj: JsonSerializable) =
    respondText(obj.toJson(), contentType = ContentType.Application.Json)
