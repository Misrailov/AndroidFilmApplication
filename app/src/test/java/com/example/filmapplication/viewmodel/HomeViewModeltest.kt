package com.example.filmapplication.viewmodel

import com.example.filmapplication.fake.repository.FakeActorsRepository
import com.example.filmapplication.fake.repository.FakeFilmsRepository
import com.example.filmapplication.fake.repository.FakeSerieRepository
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import com.example.filmapplication.repository.SerieRepository
import com.example.filmapplication.screens.home.HomeApiState
import com.example.filmapplication.screens.home.HomeListState
import com.example.filmapplication.screens.home.HomeViewModel
import junit.framework.TestCase
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeViewModeltest {
    private lateinit var viewModel: HomeViewModel
    private var actorRepository: ActorRepository = FakeActorsRepository()
    private var serieRepository: SerieRepository = FakeSerieRepository()
    private var filmRepository: FilmRepository = FakeFilmsRepository()
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getFavourites should update uiListHome and set HomeApiState to Success`() =
        testScope.runTest {
            viewModel = HomeViewModel(
                actorRepository = actorRepository,
                serieRepository = serieRepository,
                filmRepository = filmRepository
            )
            val collectCompleted = CompletableDeferred<Unit>()
            var uiListHome: HomeListState? = null
            val job = launch {
                viewModel.uiListHomeState.collect {
                    uiListHome = it
                    collectCompleted.complete(Unit)
                }
            }
            val fakeHomeState = HomeListState(series = serieRepository.getSeries("blabla",1),
                films = filmRepository.getFilms("blabla",1),
                actors = actorRepository.getActors())

            collectCompleted.await()
            advanceUntilIdle()
            TestCase.assertEquals(viewModel.homeApiState, HomeApiState.Success)
            TestCase.assertEquals(
                uiListHome!!.actors,
                fakeHomeState.actors
            )
            TestCase.assertEquals(
                uiListHome!!.films,
                fakeHomeState.films
            )
            TestCase.assertEquals(
                uiListHome!!.films,
                fakeHomeState.films
            )


            job.cancel()

        }
}