package com.example.filmapplication.viewmodel

import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.fake.repository.FakeActorsRepository
import com.example.filmapplication.fake.repository.FakeFilmsRepository
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailViewModel
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailViewUiState
import junit.framework.TestCase.assertEquals
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

class ActorDetailViewModelTest {
    private lateinit var viewModel: ActorDetailViewModel
    private var actorRepository: ActorRepository = FakeActorsRepository()
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
    fun `getActorDetails should update uiActorDetailsState and set ActorApiState to Success`() = testScope.runTest {
        viewModel = ActorDetailViewModel(actorRepository, filmRepository)
        viewModel.getActorDetails("blabla")
        val collectCompleted = CompletableDeferred<Unit>()
        var actorDetailViewUiState:ActorDetailViewUiState? = null
        val job = launch {
            actorDetailViewUiState =  (viewModel.actorDetailViewUiState as ActorDetailViewUiState.Success)
            collectCompleted.complete(Unit)
        }
        advanceUntilIdle()
        assertEquals((actorDetailViewUiState as ActorDetailViewUiState.Success).actor, FakeDataSource.actors[0])
        assertEquals((actorDetailViewUiState as ActorDetailViewUiState.Success).films, FakeDataSource.films)
        job.cancel()

    }



}


