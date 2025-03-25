package com.example.ui.mapper

import com.example.domain.models.Course
import com.example.ui.models.CourseUi
import java.text.SimpleDateFormat
import java.util.Locale

internal class DomainUiMapper {

    fun mapCourseDomainToUiList(domainCourseList: List<Course>): List<CourseUi> {
        return domainCourseList.map {
            mapCourseDomainToUi(it)
        }
    }

    private fun mapCourseDomainToUi(dto: Course) =
        dto.run {
            CourseUi(
                id = id,
                title = title,
                text = text,
                price = price,
                rate = rate,
                startDate = startDate,
                hasLike = hasLike,
                publishDate = formatDate(publishDate)
            )
        }

    private fun formatDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ru"))
        val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru"))

        val date = inputFormat.parse(inputDate)
        return date?.let {
            val formattedDate = outputFormat.format(it)
            val firstLetter = formattedDate[formattedDate.indexOf(" ") + 1]
            formattedDate.replaceFirst(firstLetter, firstLetter.uppercaseChar())
        }.orEmpty()
    }
}