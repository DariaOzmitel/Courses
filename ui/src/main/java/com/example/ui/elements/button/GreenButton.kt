package com.example.ui.elements.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextForButton
import com.example.ui.theme.CoursesTheme

@Composable
internal fun GreenButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CoursesTheme.colors.green,
            contentColor = CoursesTheme.colors.white,
            disabledContentColor = CoursesTheme.colors.white.copy(alpha = 0.1f),
            disabledContainerColor = CoursesTheme.colors.green.copy(alpha = 0.1f),
        ),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        TextForButton(text = text)
    }
}

@Preview
@Composable
private fun BigGreenButtonPreview() {
    GreenButton(text = stringResource(id = R.string.resume))
}