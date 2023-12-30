package com.example.filmapplication.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.filmapplication.data.database.FilmApplicationDb
import com.example.filmapplication.data.database.serie.SerieDao
import com.example.filmapplication.data.database.serie.asDbSerie
import com.example.filmapplication.data.database.serie.asDomainSerie
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class SerieDaoTest {
    private lateinit var serieDao: SerieDao
    private lateinit var filmApplicationDb: FilmApplicationDb

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        filmApplicationDb = Room.inMemoryDatabaseBuilder(context, FilmApplicationDb::class.java)
            .allowMainThreadQueries()
            .build()
        serieDao = filmApplicationDb.serieDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        filmApplicationDb.close()
    }
    @Test
    @Throws(Exception::class)
    fun daoInsert_insertSerieIntoDB() = runBlocking {
        serieDao.insert(FakeDataSource.series[0].asDbSerie())
        val series = serieDao.getAllItems().first()
        assertEquals(series[0].asDomainSerie(), FakeDataSource.series[0])
    }

    @Test
    @Throws(Exception::class)
    fun daoGetAllSeries_returnsAllSeriesFromDB() = runBlocking {
        FakeDataSource.series.forEach { serie ->
            serieDao.insert(serie.asDbSerie())
        }
        val series = serieDao.getAllItems().first().reversed()
        assertTrue(series.containsAll(FakeDataSource.series.map { it.asDbSerie() }))
    }
    @Test
    @Throws(Exception::class)
    fun daoDeleteOneSerie_returnTotalSize() = runBlocking {
        FakeDataSource.series.forEach { serie ->
            serieDao.insert(serie.asDbSerie())
        }
        val seriesBeforeDelete = serieDao.getAllItems().first()

        serieDao.delete(FakeDataSource.series[0].asDbSerie())
        val seriesAfterDelete = serieDao.getAllItems().first()

        assertTrue(!seriesAfterDelete.contains(FakeDataSource.series[0].asDbSerie()))
        assertEquals(seriesAfterDelete.size, seriesBeforeDelete.size - 1)
    }
    @Test
    @Throws(Exception::class)
    fun daoGetOneSpecificSerie_returnsOneSerie() = runBlocking {
        serieDao.insert(FakeDataSource.series[0].asDbSerie())
        val serie = serieDao.getItem(FakeDataSource.series[0].id).first()
        assertEquals(serie.asDomainSerie(), FakeDataSource.series[0])
    }
    @Test
    @Throws(Exception::class)
    fun daoUpdate_updateSerieInDB() = runBlocking {
        val originalSerie = FakeDataSource.series[0]
        serieDao.insert(originalSerie.asDbSerie())

        val updatedSerie = originalSerie.copy(titleText = "New Title")

        serieDao.update(updatedSerie.asDbSerie())

        val retrievedSerie = serieDao.getItem(originalSerie.id).first()

        assertEquals(retrievedSerie.titleText, "New Title")
        assertEquals(retrievedSerie.asDomainSerie(), updatedSerie)
    }




}
