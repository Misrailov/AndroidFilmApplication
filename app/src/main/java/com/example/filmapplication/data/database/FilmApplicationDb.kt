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

/**
 * Room database class for the Film Application.
 * Manages entities: [dbActor], [dbSerie], [dbFilm]
 *
 * @property actorDao DAO for managing actors in the database.
 * @property filmDao DAO for managing films in the database.
 * @property serieDao DAO for managing series in the database.
 */
@Database(entities = [dbActor::class, dbSerie::class, dbFilm::class], version = 6, exportSchema = false)
abstract class FilmApplicationDb : RoomDatabase() {

    abstract fun actorDao(): ActorDao
    abstract fun filmDao(): FilmDao
    abstract fun serieDao(): SerieDao

    companion object {
        @Volatile
        private var Instance: FilmApplicationDb? = null

        /**
         * Returns the database instance or creates a new one if it doesn't exist.
         *
         * @param context The application context.
         * @return The database instance.
         */
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
