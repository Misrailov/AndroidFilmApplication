package com.example.filmapplication.data.database.serie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for interacting with the series database table.
 */
@Dao
interface SerieDao {
    /**
     * Inserts a [dbSerie] item into the database. If there is a conflict with an existing record,
     * it replaces the existing record with the new one.
     *
     * @param item The [dbSerie] object to insert or replace.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:dbSerie)
    /**
     * Updates an existing [dbSerie] item in the database.
     *
     * @param item The [dbSerie] object to update.
     */
    @Update
    suspend fun update(item:dbSerie)
    /**
     * Deletes a [dbSerie] item from the database.
     *
     * @param item The [dbSerie] object to delete.
     */
    @Delete
    suspend fun delete(item:dbSerie)
    /**
     * Retrieves a [dbSerie] item from the database based on its unique identifier [id].
     *
     * @param id The unique identifier of the [dbSerie] item to retrieve.
     * @return A [Flow] of [dbSerie] representing the retrieved item, or an empty [Flow] if not found.
     */
    @Query("SELECT * FROM Series WHERE id = :id")
    fun getItem(id:String): Flow<dbSerie>
    /**
     * Retrieves all [dbSerie] items from the database, ordered by their title text in ascending order.
     *
     * @return A [Flow] of a list of [dbSerie] objects representing all items in the database.
     */
    @Query("SELECT * FROM Series ORDER BY titleText ASC")
    fun getAllItems():Flow<List<dbSerie>>

}