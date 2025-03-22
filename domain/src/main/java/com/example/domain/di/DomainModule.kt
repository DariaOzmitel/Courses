package com.example.domain.di

import com.example.domain.usecase.GetCoursesListFlowUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCoursesListFlowUseCase)
}