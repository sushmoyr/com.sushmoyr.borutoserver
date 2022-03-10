package com.sushmoyr.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureStatusPages() {
    install(StatusPages){
        status(HttpStatusCode.NotFound){
            call.respond(
                message = "Page Not Found",
                status = HttpStatusCode.NotFound
            )
        }
        exception<Exception> {
            call.respond(
                message = "Page Not Found",
                status = HttpStatusCode.NotFound
            )
        }
    }
}