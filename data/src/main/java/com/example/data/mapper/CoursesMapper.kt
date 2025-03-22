package com.example.data.mapper

import com.example.data.network.models.CourseDto
import com.example.domain.models.Course

internal class CoursesMapper {

    fun mapCoursesDtoListToEntityList(dtoList: List<CourseDto>): List<Course> {
        return dtoList.map {
            mapCourseDtoToEntity(it)
        }
    }

    private fun mapCourseDtoToEntity(dto: CourseDto) =
        dto.run {
            Course(
                id = id,
                title = title,
                text = text,
                price = price,
                rate = rate,
                startDate = startDate,
                hasLike = hasLike,
                publishDate = publishDate
            )
        }
}