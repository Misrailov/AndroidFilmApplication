//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[ActorRepository](index.md)

# ActorRepository

interface [ActorRepository](index.md)

Repository interface for managing actor data.

#### Inheritors

| |
|---|
| [CachingActorRepository](../-caching-actor-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Deletes an actor from the local database. |
| [getActorDetail](get-actor-detail.md) | [androidJvm]<br>abstract suspend fun [getActorDetail](get-actor-detail.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)<br>Retrieves details of an actor by their unique ID. |
| [getActors](get-actors.md) | [androidJvm]<br>abstract suspend fun [getActors](get-actors.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>Retrieves a list of actors. |
| [getAllFavourites](get-all-favourites.md) | [androidJvm]<br>abstract fun [getAllFavourites](get-all-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;&gt;<br>Retrieves a flow of all favorite actors. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;&gt;<br>Retrieves a flow of all actors. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)?&gt;<br>Retrieves an actor by their name. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Inserts an actor into the local database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)()<br>Refreshes the actor data by fetching it from the remote API. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Updates an actor in the local database. |
