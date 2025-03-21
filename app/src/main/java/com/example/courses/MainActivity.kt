package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import com.example.ui.screen.OnboardingScreen
import com.example.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Scaffold(containerColor = Color.Black) { innerPadding ->
                    OnboardingScreen(
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}