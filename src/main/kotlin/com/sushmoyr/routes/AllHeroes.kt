package com.sushmoyr.routes

import com.sushmoyr.models.ApiResponse
import com.sushmoyr.repository.HeroRepository
import com.sushmoyr.repository.HeroRepositoryImpl
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.java.KoinJavaComponent.inject
import kotlin.reflect.full.createInstance

fun Route.getAllHeroes() {
    get("/boruto/heroes") {

        val heroRepository: HeroRepository by inject(HeroRepository::class.java)

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1

            require(page in 1..5)

            val apiResponse = heroRepository.getAllHeroes(page = page)

            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes Not Found"),
                status = HttpStatusCode.NotFound
            )
        }

    }
}