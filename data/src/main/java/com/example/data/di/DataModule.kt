package com.example.data.di

import android.app.Application
import com.example.data.database.AppDatabase
import com.example.data.database.favoriteCourses.FavoriteCoursesDao
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
    singleOf(::provideFavoriteCoursesDao)
}

private fun provideFavoriteCoursesDao(application: Application): FavoriteCoursesDao {
    return AppDatabase.getInstance(application).favoriteCoursesDao()
}