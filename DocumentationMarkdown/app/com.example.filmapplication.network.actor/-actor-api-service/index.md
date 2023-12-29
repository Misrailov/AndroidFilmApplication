//[app](../../../index.md)/[com.example.filmapplication.network.actor](../index.md)/[ActorApiService](index.md)

# ActorApiService

[androidJvm]\
interface [ActorApiService](index.md)

Retrofit interface for interacting with the Actor API.

## Functions

| Name | Summary |
|---|---|
| [getActorById](get-actor-by-id.md) | [androidJvm]<br>@GET(value = &quot;actors/{id}&quot;)<br>abstract suspend fun [getActorById](get-actor-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ActorContainerSingular](../../com.example.filmapplication.model.actor/-actor-container-singular/index.md)<br>Retrieves an actor by their ID from the API. |
| [getActors](get-actors.md) | [androidJvm]<br>@GET(value = &quot;actors&quot;)<br>abstract suspend fun [getActors](get-actors.md)(): [ActorContainer](../../com.example.filmapplication.model.actor/-actor-container/index.md)<br>Retrieves a list of actors from the API. |
| [getActorsAsFlow](../get-actors-as-flow.md) | [androidJvm]<br>fun [ActorApiService](index.md).[getActorsAsFlow](../get-actors-as-flow.md)(): Flow&lt;[ActorContainer](../../com.example.filmapplication.model.actor/-actor-container/index.md)&gt;<br>Extension function to convert the getActors function to a Flow. |
