package com.example.ui.di

import com.example.ui.mapper.DomainUiMapper
import com.example.ui.screen.favoriteScreen.FavoriteScreenViewModel
import com.example.ui.screen.mainScreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::FavoriteScreenViewModel)
    singleOf(::DomainUiMapper)
}