package com.example.ui.models

data class CourseUi(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

val mockCourseUi = CourseUi(
    id = 1,
    title = "Java-разработчик с нуля",
    text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
    price = "999",
    rate = "4.9",
    startDate = "2024-05-22",
    hasLike = false,
    publishDate = "2024-02-02"
)

val mockCourseUiList = listOf(mockCourseUi, mockCourseUi, mockCourseUi, mockCourseUi)