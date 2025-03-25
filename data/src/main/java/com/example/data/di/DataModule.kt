package com.example.data.di

import com.example.data.mapper.DataDomainMapper
import com.example.data.network.ApiFactory
import com.example.data.network.ApiService
import com.example.data.repository.CoursesRepositoryImpl
import com.example.domain.repository.CoursesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class
    singleOf(::DataDomainMapper)
    single<ApiService> { ApiFactory.apiService }
}
