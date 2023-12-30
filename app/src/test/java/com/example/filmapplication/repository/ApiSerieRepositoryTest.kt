package com.example.filmapplication.repository

import com.example.filmapplication.data.database.serie.SerieDao
import com.example.filmapplication.data.database.serie.asDbSerie
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.fake.network.FakeSerieApiService
import com.example.filmapplication.model.serie.asDomainSerie
import com.example.filmapplication.network.serie.SerieApiService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ApiSerieRepositoryTest {
    private lateinit var serieDaoMock: SerieDao
    private lateinit var fakeSerieApiService: SerieApiService
    private lateinit var repository: SerieRepository

    @Before
    fun prepareMockAndFakeData() {
        serieDaoMock = mock(SerieDao::class.java)
        fakeSerieApiService = FakeSerieApiService()
        repository = CachingSerieRepository(serieDaoMock, fakeSerieApiService)
        `when`(serieDaoMock.getAllItems()).thenReturn(flowOf(FakeDataSource.series.map { it.asDbSerie() }))
        `when`(serieDaoMock.getItem(anyString())).thenReturn(flowOf(FakeDataSource.series[0].asDbSerie()))
    }

    @Test
    fun apiSerieRepositoryTest_getSeries_verifySerieList() =
        runTest {
            assertEquals(
                FakeDataSource.fakeApiSeries.map { it.asDomainSerie() },
                repository.getSeries("blabla", 123)
            )
            assertEquals(FakeDataSource.fakeApiSeries.count(),
                repository.getSeries("blabla",123).count())
            assertTrue(repository.getSeries("blabla",123).isNotEmpty())
        }

    @Test
    fun apiSerieRepositoryTest_getSerieDetail_verifySerie()=
        runTest {
            assertEquals(FakeDataSource.fakeApiSeries[0].asDomainSerie(),repository.getSerieById("blabla"))
        }
    @Test
    fun apiSerieRepositoryTest_getFavourites_verifyFavourites()=
        runTest {
            assertEquals(FakeDataSource.series,repository.getAllFavourites().first())
            assertEquals(FakeDataSource.series.count(),repository.getAllFavourites().first().count())
            assertTrue(repository.getAllFavourites().first().isNotEmpty())
        }


}