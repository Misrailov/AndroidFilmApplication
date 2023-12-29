//[app](../../../index.md)/[com.example.filmapplication.screens.actor](../index.md)/[ActorListState](index.md)

# ActorListState

[androidJvm]\
data class [ActorListState](index.md)(val actorList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf(), val favouriteActors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf())

Represents the state of the actor list within the actor screen.

## Constructors

| | |
|---|---|
| [ActorListState](-actor-list-state.md) | [androidJvm]<br>constructor(actorList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf(), favouriteActors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf()) |

## Properties

| Name | Summary |
|---|---|
| [actorList](actor-list.md) | [androidJvm]<br>val [actorList](actor-list.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>A list of [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md) objects representing the list of actors to be displayed. |
| [favouriteActors](favourite-actors.md) | [androidJvm]<br>val [favouriteActors](favourite-actors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>A list of [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md) objects representing the list of favorite actors. |
