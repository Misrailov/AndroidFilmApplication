package com.example.filmapplication.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.filmapplication.data.database.FilmApplicationDb
import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.data.database.actor.asDomainActor
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ActorDaoTest {
    private lateinit var actorDao:ActorDao
    private lateinit var filmApplicationDb: FilmApplicationDb


    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        filmApplicationDb = Room.inMemoryDatabaseBuilder(context, FilmApplicationDb::class.java)
            .allowMainThreadQueries()
            .build()
        actorDao = filmApplicationDb.actorDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        filmApplicationDb.close()
    }

    @Test
    @Throws(Exception::class)
    fun daoInert_insertActorIntoDB() = runBlocking {
        actorDao.insert(FakeDataSource.actors[0].asDbActor())
        val actors = actorDao.getAllItems().first()
        assertEquals(actors.get(0).asDomainActor(), FakeDataSource.actors[0])

    }
    @Test
    @Throws(Exception::class)
    fun daoGetAllActors_returnsAllActorsFromDB() = runBlocking {
        for (actor in FakeDataSource.actors) {
            actorDao.insert(actor.asDbActor())
        }
        val actors = actorDao.getAllItems().first().reversed()
        assertTrue(actors.containsAll(FakeDataSource.actors.map { it.asDbActor() }))

    }

    @Test
    @Throws(Exception::class)
    fun daoDeleteOneActor_returnTotalSize() = runBlocking {
        for (actor in FakeDataSource.actors) {
            actorDao.insert(actor.asDbActor())
        }
        val actors = actorDao.getAllItems().first()
        assertTrue(actors.containsAll(FakeDataSource.actors.map { it.asDbActor() }))

        actorDao.delete(FakeDataSource.actors[0].asDbActor())
        val actorsAfterDelete = actorDao.getAllItems().first()
        assertTrue(!actorsAfterDelete.contains(FakeDataSource.actors[0].asDbActor()))
        assertEquals(actorsAfterDelete.size, actors.size - 1)

    }
    @Test
    @Throws(Exception::class)
    fun DoeGetOneSpecificActor_returnsOneActor() = runBlocking {
       actorDao.insert(FakeDataSource.actors[0].asDbActor())
        val actor = actorDao.getItem(FakeDataSource.actors[0].primaryName).first()
        assertEquals(actor.asDomainActor(), FakeDataSource.actors[0])

    }
    @Test
    @Throws(Exception::class)
    fun daoUpdate_updateActorInDB() = runBlocking {
        val originalActor = FakeDataSource.actors[0]
        actorDao.insert(originalActor.asDbActor())

        val updatedActor = originalActor.copy(primaryName = "New Actor Name")
        println("$updatedActor updatedAct")
        actorDao.update(updatedActor.asDbActor())
        val actorWithOriginalName = actorDao.getItem(originalActor.primaryName).first()
        val retrievedActor = actorDao.getItem(updatedActor.primaryName).first()
        println("$retrievedActor retrievedActor")

        assertEquals(retrievedActor?.primaryName, "New Actor Name")
        assertEquals(retrievedActor?.asDomainActor(), updatedActor)
        assertEquals(actorWithOriginalName?.asDomainActor(), null)
    }



}