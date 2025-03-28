package com.example.ui.navigation

import androidx.compose.runtime.Composable
import com.example.ui.screen.AccountScreen
import com.example.ui.screen.OnboardingScreen
import com.example.ui.screen.entryScreen.EntryScreen
import com.example.ui.screen.favoriteScreen.FavoriteScreen
import com.example.ui.screen.mainScreen.MainScreen
import com.example.ui.screen.splash.SplashScreen

@Composable
fun InstallAppNavGraph() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        navigationState = navigationState,
        splashScreenContent = {
            SplashScreen { entryStatus ->
                when (entryStatus) {
                    true -> navigationState.navigateTo(
                        route = Screen.Onboarding.route,
                        inclusive = true,
                        popUpToScreen = Screen.Splash.route
                    )

                    false -> navigationState.navigateTo(
                        route = Screen.Entry.route,
                        inclusive = true,
                        popUpToScreen = Screen.Splash.route
                    )
                }
            }
        },
        onboardingScreenContent = { innerPadding ->
            OnboardingScreen(innerPadding = innerPadding) {
                navigationState.navigateTo(Screen.Entry.route)
            }
        },
        entryScreenContent = { innerPadding ->
            EntryScreen(innerPadding = innerPadding) {
                navigationState.navigateTo(Screen.Main.route)
            }
        },
        mainScreenContent = { innerPadding ->
            MainScreen(innerPadding = innerPadding)
        },
        favoriteScreenContent = { innerPadding ->
            FavoriteScreen(innerPadding = innerPadding)
        },
        accountScreenContent = { innerPadding ->
            AccountScreen(innerPadding = innerPadding)
        },
    )
}