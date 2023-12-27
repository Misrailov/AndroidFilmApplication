package com.example.filmapplication.fake.repository

import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.repository.ActorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeActorsRepository:ActorRepository {
    override suspend fun getActors(): List<DomainActor> {
        return FakeDataSource.actors
    }

    override suspend fun getActorDetail(id: String): DomainActor {
        return FakeDataSource.actors[0]
    }

    override suspend fun insert(item: DomainActor) {
    }

    override suspend fun update(item: DomainActor) {
    }

    override suspend fun delete(item: DomainActor) {
    }

    override suspend fun refresh() {
    }

    override fun getAllFavourites(): Flow<List<DomainActor>> {
        val actors = FakeDataSource.actors
        actors.forEach { it.isFavourite =true }
        return flowOf(actors)
    }

    override fun getItem(name: String): Flow<DomainActor?> {
        return flowOf(FakeDataSource.actors[0])
    }

    override fun getAllItems(): Flow<List<DomainActor>> {
       return flowOf(FakeDataSource.actors)
    }
}