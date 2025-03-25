package com.example.data.database.favoriteCourses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface FavoriteCoursesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteCourses(favoriteCoursesDbModel: FavoriteCoursesDbModel)

    @Query("SELECT COUNT(*) > 0 FROM FavoriteCoursesDbModel WHERE courseId = :courseId")
    fun isCourseFavorite(courseId: Int): Flow<Boolean>

    @Query("SELECT * FROM FavoriteCoursesDbModel")
    fun getFavoriteCoursesList(): Flow<List<FavoriteCoursesDbModel>>

    @Query("DELETE FROM FavoriteCoursesDbModel WHERE courseId=:courseId")
    suspend fun deleteFromFavorites(courseId: Int)
}