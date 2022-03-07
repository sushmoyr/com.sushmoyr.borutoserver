package com.sushmoyr.dl

import com.sushmoyr.repository.HeroRepository
import com.sushmoyr.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}