package com.example.filmapplication.data.database.film

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing films in the database.
 */
@Dao
interface FilmDao {
    /**
     * Inserts or replaces a film in the database.
     *
     * @param item The film to insert or replace.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: dbFilm)

    /**
     * Updates an existing film in the database.
     *
     * @param item The film to update.
     */
    @Update
    suspend fun update(item: dbFilm)

    /**
     * Deletes a film from the database.
     *
     * @param item The film to delete.
     */
    @Delete
    suspend fun delete(item: dbFilm)

    /**
     * Retrieves a film by its unique identifier.
     *
     * @param id The unique identifier of the film to retrieve.
     * @return A Flow emitting the film with the specified ID.
     */
    @Query("SELECT * FROM films WHERE id = :id")
    fun getItem(id: String): Flow<dbFilm>

    /**
     * Retrieves all films in the database, ordered by title text.
     *
     * @return A Flow emitting a list of all films.
     */
    @Query("SELECT * FROM films ORDER BY titleText")
    fun getAllItems(): Flow<List<dbFilm>>
}
