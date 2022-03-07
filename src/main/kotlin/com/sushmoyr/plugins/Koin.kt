package com.sushmoyr.plugins

import com.sushmoyr.dl.koinModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger(level = org.koin.core.logger.Level.ERROR) //This params are the workaround itself
        modules(
            //specify your modules
            koinModule
        )
    }
}