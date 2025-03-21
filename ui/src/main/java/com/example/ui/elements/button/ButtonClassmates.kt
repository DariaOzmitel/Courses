package com.example.ui.elements.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.CoursesTheme

@Composable
internal fun ButtonClassmates(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth()
            .background(
                brush = CoursesTheme.colors.classmatesGradient,
                shape = RoundedCornerShape(30.dp)
            ),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = CoursesTheme.colors.white,
        ),
        contentPadding = PaddingValues(vertical = 0.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.classmates), contentDescription = "")
    }
}

@Preview
@Composable
private fun ButtonClassmatesPreview() {
    ButtonClassmates()
}