package com.example.data.mapper

import com.example.data.network.models.CourseDto
import com.example.domain.models.Course

internal class DataDomainMapper {

    fun mapCoursesDtoListToEntityList(
        dtoList: List<CourseDto>,
        favoriteCoursesId: List<Int>? = emptyList()
    ): List<Course> {
        return dtoList.map {
            mapCourseDtoToEntity(it, favoriteCoursesId)
        }
    }

    private fun mapCourseDtoToEntity(dto: CourseDto, favoriteCoursesId: List<Int>? = null) =
        dto.run {
            Course(
                id = id,
                title = title,
                text = text,
                price = price,
                rate = rate,
                startDate = startDate,
                hasLike = favoriteCoursesId?.contains(id) ?: false,
                publishDate = publishDate
            )
        }
}