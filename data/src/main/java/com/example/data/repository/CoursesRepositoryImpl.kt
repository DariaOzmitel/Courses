package com.example.data.repository

import android.util.Log
import com.example.data.mapper.DataDomainMapper
import com.example.data.network.ApiService
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class CoursesRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: DataDomainMapper
) : CoursesRepository {
    override fun getCoursesListFlow(): Flow<List<Course>> = flow {
        try {
            val response = withContext(Dispatchers.IO) { apiService.getCoursesList() }
            val mappedCourses = mapper.mapCoursesDtoListToEntityList(response?.courses.orEmpty())
            coursesList.emit(mappedCourses)
        } catch (e: Exception) {
            Log.e("CoursesFlow", "Error fetching courses", e)
            coursesList.emit(emptyList())
        }
        emitAll(coursesList)
    }.flowOn(Dispatchers.IO)


    override fun sortListByPublishingDate() {
        val currentList = coursesList.replayCache.firstOrNull().orEmpty()
        coursesList.tryEmit(currentList.sortedByDescending { it.publishDate })
    }

    private val coursesList = MutableSharedFlow<List<Course>>(replay = 1)
}