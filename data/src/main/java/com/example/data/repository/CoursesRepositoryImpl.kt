package com.example.data.repository

import android.util.Log
import com.example.data.database.favoriteCourses.FavoriteCoursesDao
import com.example.data.database.favoriteCourses.FavoriteCoursesDbModel
import com.example.data.mapper.DataDomainMapper
import com.example.data.network.ApiService
import com.example.data.network.models.CourseDto
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

internal class CoursesRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: DataDomainMapper,
    private val favoriteCoursesDao: FavoriteCoursesDao,
) : CoursesRepository {
    override fun getCoursesListFlow(): Flow<List<Course>> {
        val responseFlow: Flow<List<CourseDto>> = flow {
            try {
                val response = apiService.getCoursesList()?.courses ?: emptyList()
                emit(response)
            } catch (e: Exception) {
                Log.e("CoursesFlow", "Error fetching courses", e)
                emit(emptyList())
            }
        }.flowOn(Dispatchers.IO)
        val favoriteCoursesList = getFavoriteCoursesListFromDb()
        combine(
            responseFlow,
            favoriteCoursesList
        ) { coursesDto, favoriteCourses ->
            mapper.mapCoursesDtoListToEntityList(coursesDto, favoriteCourses)
        }.onEach { coursesList.emit(it) }
            .launchIn(CoroutineScope(Dispatchers.IO))
        return coursesList
    }

    override fun getFavoriteCoursesListFlow(): Flow<List<Course>> =
        coursesList.map { courses ->
            courses.filter {
                it.hasLike
            }
        }


    override fun sortListByPublishingDate() {
        val currentList = coursesList.replayCache.firstOrNull().orEmpty()
        coursesList.tryEmit(currentList.sortedByDescending { it.publishDate })
    }

    override suspend fun changeFavoriteStatus(courseId: Int) {
        val isCourseFavorite = favoriteCoursesDao.isCourseFavorite(courseId).first()
        when (isCourseFavorite) {
            true -> {
                favoriteCoursesDao.deleteFromFavorites(courseId)
            }

            false -> {
                favoriteCoursesDao.addFavoriteCourses(FavoriteCoursesDbModel(courseId))
            }
        }
    }

    private val coursesList = MutableSharedFlow<List<Course>>(replay = 1)

    private fun getFavoriteCoursesListFromDb(): Flow<List<Int>> =
        favoriteCoursesDao.getFavoriteCoursesList().map { coursesDbModelList ->
            coursesDbModelList.map { it.courseId }
        }
}