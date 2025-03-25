package com.example.ui.screen.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCoursesListFlowUseCase
import com.example.domain.usecase.SortListByPublishingDateUseCase
import com.example.ui.mapper.DomainUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainScreenViewModel(
    private val getCoursesListFlowUseCase: GetCoursesListFlowUseCase,
    private val sortListByPublishingDateUseCase: SortListByPublishingDateUseCase,
    private val mapper: DomainUiMapper
) : ViewModel() {
    private val mainStateMutable =
        MutableStateFlow<MainState>(MainState.Loading)
    private val mainState: StateFlow<MainState> = mainStateMutable

    init {
        viewModelScope.launch {
            getCoursesList()
        }
    }

    fun getMainState(): StateFlow<MainState> = mainState

    fun sortListByPublishingDate() {
        sortListByPublishingDateUseCase.invoke()
    }

    private fun getCoursesList() {
        viewModelScope.launch {
            getCoursesListFlowUseCase.invoke().collect { coursesList ->
                mainStateMutable.update {
                    MainState.CoursesList(mapper.mapCourseDomainToUiList(coursesList))
                }
            }
        }
    }
}