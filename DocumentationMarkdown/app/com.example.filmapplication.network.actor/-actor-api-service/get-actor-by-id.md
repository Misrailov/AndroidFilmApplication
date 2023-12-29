//[app](../../../index.md)/[com.example.filmapplication.network.actor](../index.md)/[ActorApiService](index.md)/[getActorById](get-actor-by-id.md)

# getActorById

[androidJvm]\

@GET(value = &quot;actors/{id}&quot;)

abstract suspend fun [getActorById](get-actor-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ActorContainerSingular](../../com.example.filmapplication.model.actor/-actor-container-singular/index.md)

Retrieves an actor by their ID from the API.

#### Return

An [ActorContainerSingular](../../com.example.filmapplication.model.actor/-actor-container-singular/index.md) containing a single actor's data.

#### Parameters

androidJvm

| | |
|---|---|
| id | The ID of the actor to retrieve. |
