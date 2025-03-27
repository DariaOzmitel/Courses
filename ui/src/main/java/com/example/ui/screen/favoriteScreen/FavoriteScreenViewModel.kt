package com.example.ui.screen.favoriteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.coursesRepository.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.coursesRepository.GetFavoriteCoursesListFlowUseCase
import com.example.ui.mapper.DomainUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class FavoriteScreenViewModel(
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val getFavoriteCoursesListFlowUseCase: GetFavoriteCoursesListFlowUseCase,
    private val mapper: DomainUiMapper
) : ViewModel() {
    private val favoriteStateMutable =
        MutableStateFlow<FavoriteState>(FavoriteState.Loading)
    private val favoriteState: StateFlow<FavoriteState> = favoriteStateMutable

    init {
        viewModelScope.launch {
            getCoursesList()
        }
    }

    fun getFavoriteState(): StateFlow<FavoriteState> = favoriteState

    fun changeFavoriteStatus(courseId: Int) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(courseId)
        }
    }

    private fun getCoursesList() {
        viewModelScope.launch {
            getFavoriteCoursesListFlowUseCase.invoke().collect { coursesList ->
                favoriteStateMutable.update {
                    FavoriteState.CoursesList(mapper.mapCourseDomainToUiList(coursesList))
                }
            }
        }
    }
}