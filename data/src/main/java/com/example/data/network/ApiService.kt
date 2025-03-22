package com.example.data.network

import com.example.data.network.models.CoursesDto
import retrofit2.http.GET

internal interface ApiService {
    @GET("b7dd9788fe0c60a1bee586930d179d83f599c892/courses.json")
    suspend fun getCoursesList(): CoursesDto?
}