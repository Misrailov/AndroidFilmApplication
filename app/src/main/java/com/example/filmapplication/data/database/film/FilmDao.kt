package com.example.filmapplication.data.database.film

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:dbFilm)

    @Update
    suspend fun update(item:dbFilm)

    @Delete
    suspend fun delete(item:dbFilm)

    @Query("SELECT * FROM films WHERE id = :id")
    fun getItem(id:String): Flow<dbFilm>

    @Query("SELECT * FROM films ORDER BY titleText")
    fun getAllItems():Flow<List<dbFilm>>
}