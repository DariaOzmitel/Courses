package com.example.ui.elements.button

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.CoursesTheme

@Composable
internal fun ButtonClassmates(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val context = LocalContext.current
    val url = CLASSMATES_URL
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }, modifier = modifier
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

private const val CLASSMATES_URL = "https://ok.ru/"

@Preview
@Composable
private fun ButtonClassmatesPreview() {
    ButtonClassmates()
}