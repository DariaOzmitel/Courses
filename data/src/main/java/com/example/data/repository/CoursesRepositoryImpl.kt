package com.example.data.repository

import android.util.Log
import com.example.data.mapper.CoursesMapper
import com.example.data.network.ApiService
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class CoursesRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: CoursesMapper
) : CoursesRepository {
    override fun getCoursesListFlow(): Flow<List<Course>> = flow {
        try {
            val response = withContext(Dispatchers.IO) { apiService.getCoursesList() }
            val mappedCourses =
                mapper.mapCoursesDtoListToEntityList(response?.courses ?: emptyList())
            emit(mappedCourses)
        } catch (e: Exception) {
            Log.e("CoursesFlow", "Error fetching courses", e)
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}