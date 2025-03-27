package com.example.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.screen.root.RootScreen

@Composable
internal fun AppNavGraph(
    navHostController: NavHostController,
    navigationState: NavigationState,
    splashScreenContent: @Composable () -> Unit,
    onboardingScreenContent: @Composable (PaddingValues) -> Unit,
    entryScreenContent: @Composable (PaddingValues) -> Unit,
    mainScreenContent: @Composable (PaddingValues) -> Unit,
    favoriteScreenContent: @Composable (PaddingValues) -> Unit,
    accountScreenContent: @Composable (PaddingValues) -> Unit,
) {
    RootScreen(navigationState = navigationState) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Splash.route
        ) {
            composable(Screen.Splash.route) {
                splashScreenContent()
            }
            composable(Screen.Onboarding.route) {
                onboardingScreenContent(innerPadding)
            }
            composable(Screen.Entry.route) {
                entryScreenContent(innerPadding)
            }
            composable(Screen.Main.route) {
                mainScreenContent(innerPadding)
            }
            composable(Screen.Favorite.route) {
                favoriteScreenContent(innerPadding)
            }
            composable(Screen.Account.route) {
                accountScreenContent(innerPadding)
            }
        }
    }
}