package com.example.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.authorizationRepository.CheckEntryUseCase
import com.example.domain.usecase.authorizationRepository.SetFirstEntryFlagUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SplashScreenViewModel(
    private val setFirstEntryFlagUseCase: SetFirstEntryFlagUseCase,
    private val checkEntryUseCase: CheckEntryUseCase,
) : ViewModel() {

    private val isEntryFirstMutable = MutableStateFlow(true)
    private val isEntryFirst: StateFlow<Boolean> = isEntryFirstMutable

    init {
        checkEntry()
    }

    fun getEntryStatus(): StateFlow<Boolean> = isEntryFirst

    private fun checkEntry() {
        viewModelScope.launch {
            val entryStatus = checkEntryUseCase.invoke()
            isEntryFirstMutable.value = !entryStatus
            if (entryStatus) {
                setFirstEntryFlagUseCase()
            }
        }
    }
}