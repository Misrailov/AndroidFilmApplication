package com.example.filmapplication.repository

import com.example.filmapplication.data.database.film.FilmDao
import com.example.filmapplication.data.database.film.asDbFilm
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.fake.network.FakeFilmApiService
import com.example.filmapplication.model.film.asDomainFilm
import com.example.filmapplication.network.movie.FilmApiService
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.kotlin.verify

class ApiFilmRepositoryTest {
    lateinit var filmsDaoMock: FilmDao
    lateinit var fakeFilmApiService: FilmApiService
    lateinit var repository: FilmRepository

    @Before
    fun prepareMockAndFakeData() {
        filmsDaoMock = mock(FilmDao::class.java)
        fakeFilmApiService = FakeFilmApiService()
        repository = CachingFilmRepository(filmsDaoMock, fakeFilmApiService)
        `when`(filmsDaoMock.getAllItems()).thenReturn(flowOf(FakeDataSource.films.map { it.asDbFilm() }))
        `when`(filmsDaoMock.getItem(anyString())).thenReturn(flowOf(FakeDataSource.films[0].asDbFilm()))

    }

    @Test
    fun apiFilmRepositoryTest_getFilms_verifyFilmsList() =
        runTest {

            assertEquals(
                FakeDataSource.fakeApiFilms.map { it.asDomainFilm() },
                repository.getFilms("blabla", 123)
            )
            assertEquals(
                FakeDataSource.fakeApiFilms.count(), repository.getFilms(
                   "blabla",
                    123
                ).count()
            )
            assertTrue(repository.getFilms("blabla", 123).isNotEmpty())
        }

    @Test
    fun apiFilmRepositoryTest_getFilmDetail_verifyFilm()=
        runTest {
            assertEquals(
                FakeDataSource.fakeApiFilms[0].asDomainFilm(),repository.getFilmDetail("blabla")
            )
        }

    @Test
    fun apiFilmrepositorytest_getFavourites_verifyFavouritesList()=
        run {
        runTest {
            assertEquals(FakeDataSource.films,repository.getAllFavourites().first())
            assertEquals(FakeDataSource.films.count(),repository.getAllFavourites().first().count())
            assertTrue(repository.getAllFavourites().first().isNotEmpty())
        }}
}