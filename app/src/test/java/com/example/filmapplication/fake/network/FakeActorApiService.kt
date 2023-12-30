package com.example.filmapplication.fake.network

import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.model.actor.ActorContainer
import com.example.filmapplication.model.actor.ActorContainerSingular
import com.example.filmapplication.model.actor.ApiActor
import com.example.filmapplication.network.actor.ActorApiService

class FakeActorApiService : ActorApiService {
    override suspend fun getActors(): ActorContainer {
        return ActorContainer(1, "", FakeDataSource.actors.count(), FakeDataSource.actors.map {
            ApiActor(
                it.nconst,
                it.primaryName,
                it.birthYear,
                it.deathYear,
                it.primaryProfession,
                it.knownForTitles
            )
        })
    }

    override suspend fun getActorById(id: String): ActorContainerSingular {
        val domainActor = FakeDataSource.actors[0]
        return ActorContainerSingular(
            ApiActor(
                domainActor.nconst,
                domainActor.primaryName,
                domainActor.birthYear,
                domainActor.deathYear,
                domainActor.primaryProfession,
                domainActor.knownForTitles
            )
        )
    }
}
