package com.slakra.di

import com.slakra.network.repository.TestRepository
import org.koin.dsl.module.module

internal val repositoryModule = module {

    single { TestRepository(apiService = get(), testDao = get()) }
}