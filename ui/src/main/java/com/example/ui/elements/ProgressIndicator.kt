package com.example.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ui.theme.CoursesTheme

@Composable
internal fun ProgressIndicator(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier.size(100.dp),
    color: Color = CoursesTheme.colors.green
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = contentModifier,
            color = color,
            strokeWidth = 4.dp
        )
    }
}