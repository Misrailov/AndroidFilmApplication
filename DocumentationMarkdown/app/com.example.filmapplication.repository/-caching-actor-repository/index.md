//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[CachingActorRepository](index.md)

# CachingActorRepository

[androidJvm]\
class [CachingActorRepository](index.md)(actorDao: [ActorDao](../../com.example.filmapplication.data.database.actor/-actor-dao/index.md), actorApiService: [ActorApiService](../../com.example.filmapplication.network.actor/-actor-api-service/index.md)) : [ActorRepository](../-actor-repository/index.md)

Implementation of [ActorRepository](../-actor-repository/index.md) that caches actor data.

## Constructors

| | |
|---|---|
| [CachingActorRepository](-caching-actor-repository.md) | [androidJvm]<br>constructor(actorDao: [ActorDao](../../com.example.filmapplication.data.database.actor/-actor-dao/index.md), actorApiService: [ActorApiService](../../com.example.filmapplication.network.actor/-actor-api-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>open suspend override fun [delete](delete.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Deletes an actor from the local database. |
| [getActorDetail](get-actor-detail.md) | [androidJvm]<br>open suspend override fun [getActorDetail](get-actor-detail.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)<br>Retrieves details of an actor by their unique ID from the remote API. |
| [getActors](get-actors.md) | [androidJvm]<br>open suspend override fun [getActors](get-actors.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>Retrieves a list of actors by fetching them from the remote API. |
| [getAllFavourites](get-all-favourites.md) | [androidJvm]<br>open override fun [getAllFavourites](get-all-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;&gt;<br>Retrieves a flow of all favorite actors from the local database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>open override fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;&gt;<br>Retrieves a flow of all actors from the local database. |
| [getItem](get-item.md) | [androidJvm]<br>open override fun [getItem](get-item.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)?&gt;<br>Retrieves an actor by their name from the local database. |
| [insert](insert.md) | [androidJvm]<br>open suspend override fun [insert](insert.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Inserts an actor into the local database. |
| [refresh](refresh.md) | [androidJvm]<br>open suspend override fun [refresh](refresh.md)()<br>Refreshes the actor data by fetching it from the remote API and updating the local database. |
| [update](update.md) | [androidJvm]<br>open suspend override fun [update](update.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Updates an actor in the local database. |
