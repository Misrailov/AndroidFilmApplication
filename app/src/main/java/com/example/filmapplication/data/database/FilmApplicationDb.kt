package com.example.filmapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.dbActor
import com.example.filmapplication.data.database.film.FilmDao
import com.example.filmapplication.data.database.film.dbFilm
import com.example.filmapplication.data.database.serie.SerieDao
import com.example.filmapplication.data.database.serie.dbSerie


@Database(entities = [dbActor::class,dbSerie::class,dbFilm::class], version = 4, exportSchema = false)
abstract class FilmApplicationDb : RoomDatabase() {

    abstract fun actorDao(): ActorDao
    abstract fun filmDao():FilmDao
    abstract fun serieDao():SerieDao
    companion object {
        @Volatile
        private var Instance: FilmApplicationDb? = null

        fun getDatabase(context: Context): FilmApplicationDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FilmApplicationDb::class.java, "application_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }

        }
    }
}