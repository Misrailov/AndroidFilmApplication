package com.example.filmapplication.data.database.actor

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ActorDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insert(item:dbActor)

    @Update
    suspend fun update(item:dbActor)

    @Delete
    suspend fun delete(item:dbActor)


    @Query("SELECT * from actors WHERE primaryName = :name")
    fun getItem(name: String): Flow<dbActor>

    @Query("SELECT * from actors ORDER BY primaryName ASC")
    fun getAllItems(): Flow<List<dbActor>>
}