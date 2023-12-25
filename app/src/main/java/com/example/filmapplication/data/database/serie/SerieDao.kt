package com.example.filmapplication.data.database.serie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface SerieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:dbSerie)

    @Update
    suspend fun update(item:dbSerie)

    @Delete
    suspend fun delete(item:dbSerie)

    @Query("SELECT * FROM Series WHERE id = :id")
    fun getItem(id:String): Flow<dbSerie>
    @Query("SELECT * FROM Series ORDER BY titleText ASC")
    fun getAllItems():Flow<List<dbSerie>>

}