package com.sushmoyr.routes

import com.sushmoyr.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

fun Route.searchHeroes() {
    val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    get("/boruto/heroes/search") {
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.searchHeroes(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }

}