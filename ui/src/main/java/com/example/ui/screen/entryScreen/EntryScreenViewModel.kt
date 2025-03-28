package com.example.ui.screen.entryScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class EntryScreenViewModel : ViewModel() {
    private val entryStateMutable =
        MutableStateFlow(EntryState())
    private val entryState: StateFlow<EntryState> = entryStateMutable

    fun getEntryState(): StateFlow<EntryState> = entryState

    fun updateMail(mail: String) {
        val regex = Regex("^[a-zA-Z0-9@._-]*$")
        if (regex.matches(mail)) {
            entryStateMutable.update { state ->
                state.copy(
                    mail = mail,
                    areFieldsCorrect = areFieldsCorrect(mail = mail, password = state.password)
                )
            }
        }
    }

    fun updatePassword(password: String) {
        entryStateMutable.update { state ->
            state.copy(
                password = password,
                areFieldsCorrect = areFieldsCorrect(password = password, mail = state.mail)
            )
        }
    }

    private val emailPattern = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

    private fun areFieldsCorrect(mail: String, password: String): Boolean =
        mail.matches(emailPattern) && mail.isNotEmpty() && password.isNotEmpty()
}