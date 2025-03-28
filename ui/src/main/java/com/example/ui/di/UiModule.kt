package com.example.ui.di

import com.example.ui.mapper.DomainUiMapper
import com.example.ui.screen.entryScreen.EntryScreenViewModel
import com.example.ui.screen.favoriteScreen.FavoriteScreenViewModel
import com.example.ui.screen.mainScreen.MainScreenViewModel
import com.example.ui.screen.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::FavoriteScreenViewModel)
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::EntryScreenViewModel)
    singleOf(::DomainUiMapper)
}