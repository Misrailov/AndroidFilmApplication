package com.example.filmapplication.data.database.actor

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmapplication.model.actor.Actor


@Database(entities = [dbActor::class], version = 2, exportSchema = false)
abstract class ActorDb:RoomDatabase() {

abstract fun actorDao():ActorDao
    companion object {
        @Volatile
        private var Instance: ActorDb? = null

        fun getDatabase(context: Context): ActorDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ActorDb::class.java, "actor_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
              }
}}}