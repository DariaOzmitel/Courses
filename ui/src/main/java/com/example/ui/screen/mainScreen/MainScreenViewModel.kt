package com.example.ui.screen.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.coursesRepository.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.coursesRepository.GetCoursesListFlowUseCase
import com.example.domain.usecase.coursesRepository.SortListByPublishingDateUseCase
import com.example.ui.mapper.DomainUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainScreenViewModel(
    private val getCoursesListFlowUseCase: GetCoursesListFlowUseCase,
    private val sortListByPublishingDateUseCase: SortListByPublishingDateUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
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

    fun changeFavoriteStatus(courseId: Int) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(courseId)
        }
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