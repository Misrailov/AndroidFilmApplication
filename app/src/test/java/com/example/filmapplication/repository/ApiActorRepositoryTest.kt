package com.example.filmapplication.repository

import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.data.database.film.FilmDao
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.fake.network.FakeActorApiService
import com.example.filmapplication.fake.network.FakeFilmApiService
import com.example.filmapplication.fake.repository.FakeActorsRepository
import com.example.filmapplication.network.actor.ActorApiService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.any
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ApiActorRepositoryTest {
    lateinit var actorsDaoMock: ActorDao
    lateinit var fakeActorApiService: ActorApiService
    lateinit var repository: ActorRepository

    @Before
    fun prepareMockAndFakeData() {
        actorsDaoMock = mock(ActorDao::class.java)
        fakeActorApiService = FakeActorApiService()
        repository = CachingActorRepository(actorsDaoMock, fakeActorApiService)
        `when`(actorsDaoMock.getAllItems()).thenReturn(flowOf(FakeDataSource.actors.map { it.asDbActor() }))
        `when`(actorsDaoMock.getItem(anyString())).thenReturn(flowOf(FakeDataSource.actors[0].asDbActor()))
        `when`(actorsDaoMock.getFavourites()).thenReturn(flowOf(FakeDataSource.actors.map { it.asDbActor() }))

    }

    @Test
    fun apiActorRepositoryTest_getActors_verifyActorsList() =
        runTest {


            assertEquals(FakeDataSource.actors, repository.getActors())
            assertEquals(FakeDataSource.actors.count(), repository.getActors().count())
            assertTrue(repository.getActors().isNotEmpty())

        }

    @Test
    fun apiActorRepositoryTest_getActorDetail_verifyActor() =
        runTest {
            assertEquals(FakeDataSource.actors[0], repository.getActorDetail("blabla"))
            assertEquals(FakeDataSource.actors[0].nconst, repository.getActorDetail("blabla").nconst)
            assertTrue(!repository.getActorDetail("blabla").isFavourite)

        }

    @Test
    fun apiActorRepositoryTest_getFavourites_verifyActorsList() =
        runTest {
            print(repository.getAllFavourites())
            println(FakeDataSource.actors)
            assertEquals(FakeDataSource.actors, repository.getAllFavourites().first())
        }

}