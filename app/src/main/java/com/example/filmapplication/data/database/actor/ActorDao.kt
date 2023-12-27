package com.example.filmapplication.data.database.actor

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing actors in the database.
 */
@Dao
interface ActorDao {
    /**
     * Inserts or replaces an actor in the database.
     *
     * @param item The actor to insert or replace.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: dbActor)

    /**
     * Updates an existing actor in the database.
     *
     * @param item The actor to update.
     */
    @Update
    suspend fun update(item: dbActor)

    /**
     * Deletes an actor from the database.
     *
     * @param item The actor to delete.
     */
    @Delete
    suspend fun delete(item: dbActor)

    /**
     * Retrieves an actor by their primary name.
     *
     * @param name The primary name of the actor to retrieve.
     * @return A Flow emitting the actor with the specified name.
     */
    @Query("SELECT * FROM actors WHERE primaryName = :name")
    fun getItem(name: String): Flow<dbActor>

    /**
     * Retrieves all actors in the database, ordered by primary name in ascending order.
     *
     * @return A Flow emitting a list of all actors.
     */
    @Query("SELECT * FROM actors ORDER BY primaryName ASC")
    fun getAllItems(): Flow<List<dbActor>>

    /**
     * Retrieves all favorite actors from the database, ordered by primary name in ascending order.
     *
     * @return A Flow emitting a list of favorite actors.
     */
    @Query("SELECT * FROM actors WHERE isFavourite = 1 ORDER BY primaryName ASC")
    fun getFavourites(): Flow<List<dbActor>>
}
