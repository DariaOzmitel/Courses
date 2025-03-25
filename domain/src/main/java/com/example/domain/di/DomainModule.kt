package com.example.domain.di

import com.example.domain.usecase.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.GetCoursesListFlowUseCase
import com.example.domain.usecase.GetFavoriteCoursesListFlowUseCase
import com.example.domain.usecase.SortListByPublishingDateUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCoursesListFlowUseCase)
    factoryOf(::SortListByPublishingDateUseCase)
    factoryOf(::ChangeFavoriteStatusUseCase)
    factoryOf(::GetFavoriteCoursesListFlowUseCase)
}