package com.example.ui.navigation

internal sealed class Screen(val route: String) {
    object Onboarding : Screen(ROUTE_ONBOARDING)
    object Entry : Screen(ROUTE_ENTRY)
    object Main : Screen(ROUTE_MAIN)
    object Favorite : Screen(ROUTE_FAVORITE)
    object Account : Screen(ROUTE_ACCOUNT)

    companion object {
        private const val ROUTE_ONBOARDING = "onboarding"
        private const val ROUTE_ENTRY = "entry"
        private const val ROUTE_MAIN = "main"
        private const val ROUTE_FAVORITE = "favorite"
        private const val ROUTE_ACCOUNT = "account"
    }
}