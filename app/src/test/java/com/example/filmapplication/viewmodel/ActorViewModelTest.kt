package com.example.filmapplication.viewmodel

import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.fake.repository.FakeActorsRepository
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.screens.actor.ActorApiState
import com.example.filmapplication.screens.actor.ActorListState
import com.example.filmapplication.screens.actor.ActorViewModel
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mockito
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

class ActorViewModelTest {
    private lateinit var viewModel: ActorViewModel
    private var actorRepository: ActorRepository = FakeActorsRepository()
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

    @Test
    fun `getActors should update uiListActorState and set ActorApiState to Success`() =testScope.runTest {
       viewModel = ActorViewModel(actorRepository)
        val collectCompleted = CompletableDeferred<Unit>()
        var uiListActorState:ActorListState? = null
        val job = launch {
            viewModel.uiListActorState.collect {
                uiListActorState = it
                collectCompleted.complete(Unit)
            }
        }

        collectCompleted.await()
        advanceUntilIdle()
        assertEquals(viewModel.actorApiState, ActorApiState.Success)
        assertEquals(uiListActorState!!.actorList,ActorListState(actorRepository.getActors()).actorList)
        assertTrue(uiListActorState!!.actorList.isNotEmpty())

        job.cancel()

    }
    @Test
    fun `addActorToFavourites should update uiListActorState with the correct data and set ActorApiState to Success`() = testScope.runTest {
        viewModel = ActorViewModel(actorRepository)
        val collectCompleted = CompletableDeferred<Unit>()
        var uiListActorState:ActorListState? = null
        val job = launch {
            viewModel.uiListActorState.collect {
                uiListActorState = it
                collectCompleted.complete(Unit)
            }
        }
        collectCompleted.await()
        advanceUntilIdle()
        assertEquals(viewModel.actorApiState, ActorApiState.Success)
        viewModel.addActorToFavourites(FakeDataSource.actors[0])
        assertEquals(uiListActorState!!.favouriteActors,ActorListState(actorRepository.getActors(),FakeDataSource.actors).favouriteActors)
        assertTrue(uiListActorState!!.favouriteActors.isNotEmpty())
        job.cancel()
    }

}
