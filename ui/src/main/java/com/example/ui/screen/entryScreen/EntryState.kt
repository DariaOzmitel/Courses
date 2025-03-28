package com.example.ui.screen.entryScreen

internal data class EntryState(
    val mail: String = "",
    val password: String = "",
    val areFieldsCorrect: Boolean = false,
)