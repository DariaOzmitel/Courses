package com.example.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.ui.elements.text.TextButtonSmall
import com.example.ui.navigation.BottomNavigationItem
import com.example.ui.navigation.NavigationState
import com.example.ui.navigation.rememberNavigationState
import com.example.ui.theme.CoursesTheme

@Composable
internal fun CoursesBottomBar(
    modifier: Modifier = Modifier,
    navBackStackEntry: NavBackStackEntry?,
    navigationState: NavigationState
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = CoursesTheme.colors.darkGrey
    ) {
        BottomNavigationItem.entries.forEach { item ->
            val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navigationState.navigateTo(item.screen.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = item.name
                    )
                },
                label = {
                    TextButtonSmall(
                        modifier = Modifier.padding(bottom = 12.dp),
                        text = stringResource(id = item.titleResId)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = CoursesTheme.colors.white,
                    unselectedTextColor = CoursesTheme.colors.white,
                    selectedIconColor = CoursesTheme.colors.green,
                    selectedTextColor = CoursesTheme.colors.green
                )
            )
        }
    }
}

@Preview
@Composable
internal fun CoursesBottomBarPreview() {
    CoursesBottomBar(
        navBackStackEntry = rememberNavigationState().navHostController.currentBackStackEntry,
        navigationState = NavigationState(rememberNavigationState().navHostController)
    )
}