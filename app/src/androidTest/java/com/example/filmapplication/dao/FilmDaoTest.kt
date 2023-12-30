package com.example.filmapplication.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.filmapplication.data.database.FilmApplicationDb
import com.example.filmapplication.data.database.film.FilmDao
import com.example.filmapplication.data.database.film.asDbFilm
import com.example.filmapplication.data.database.film.asDomainFilm
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class FilmDaoTest {
    private lateinit var filmDao: FilmDao
    private lateinit var filmApplicationDb: FilmApplicationDb

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        filmApplicationDb = Room.inMemoryDatabaseBuilder(context, FilmApplicationDb::class.java)
            .allowMainThreadQueries()
            .build()
        filmDao = filmApplicationDb.filmDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        filmApplicationDb.close()
    }

    @Test
    @Throws(Exception::class)
    fun daoInert_insertActorIntoDB() = runBlocking {
        filmDao.insert(FakeDataSource.films[0].asDbFilm())
        val films = filmDao.getAllItems().first()
        assertEquals(films[0].asDomainFilm(), FakeDataSource.films[0])

    }
    @Test
    @Throws(Exception::class)
    fun daoGetAllFilms_returnsAllFilmsFromDB() = runBlocking {
        FakeDataSource.films.forEach { film ->
            filmDao.insert(film.asDbFilm())
        }
        val films = filmDao.getAllItems().first().reversed()
        assertTrue(films.containsAll(FakeDataSource.films.map { it.asDbFilm() }))
    }
    @Test
    @Throws(Exception::class)
    fun daoDeleteOneFilm_returnTotalSize() = runBlocking {
        FakeDataSource.films.forEach { film ->
            filmDao.insert(film.asDbFilm())
        }
        val filmsBeforeDelete = filmDao.getAllItems().first()

        filmDao.delete(FakeDataSource.films[0].asDbFilm())
        val filmsAfterDelete = filmDao.getAllItems().first()

        assertTrue(!filmsAfterDelete.contains(FakeDataSource.films[0].asDbFilm()))
        assertEquals(filmsAfterDelete.size, filmsBeforeDelete.size - 1)
    }
    @Test
    @Throws(Exception::class)
    fun daoGetOneSpecificFilm_returnsOneFilm() = runBlocking {
        filmDao.insert(FakeDataSource.films[0].asDbFilm())
        val film = filmDao.getItem(FakeDataSource.films[0].id).first()
        assertEquals(film.asDomainFilm(), FakeDataSource.films[0])
    }
    @Test
    @Throws(Exception::class)
    fun daoUpdate_updateFilmInDB() = runBlocking {
        val originalFilm = FakeDataSource.films[0]
        filmDao.insert(originalFilm.asDbFilm())

        val updatedFilm = originalFilm.copy(titleText = "New Film Title")

        filmDao.update(updatedFilm.asDbFilm())

        val retrievedFilm = filmDao.getItem(originalFilm.id).first()

        assertEquals(retrievedFilm.titleText, "New Film Title")
        assertEquals(retrievedFilm.asDomainFilm(), updatedFilm)
    }


}