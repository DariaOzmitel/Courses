package com.example.domain.di

import com.example.domain.usecase.authorizationRepository.CheckEntryUseCase
import com.example.domain.usecase.authorizationRepository.SetFirstEntryFlagUseCase
import com.example.domain.usecase.coursesRepository.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.coursesRepository.GetCoursesListFlowUseCase
import com.example.domain.usecase.coursesRepository.GetFavoriteCoursesListFlowUseCase
import com.example.domain.usecase.coursesRepository.SortListByPublishingDateUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCoursesListFlowUseCase)
    factoryOf(::SortListByPublishingDateUseCase)
    factoryOf(::ChangeFavoriteStatusUseCase)
    factoryOf(::GetFavoriteCoursesListFlowUseCase)
    factoryOf(::SetFirstEntryFlagUseCase)
    factoryOf(::CheckEntryUseCase)
}