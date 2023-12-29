//[app](../../index.md)/[com.example.filmapplication.screens.actor](index.md)/[ActorList](-actor-list.md)

# ActorList

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ActorList](-actor-list.md)(actors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;, favActors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;, addActorToFav: (item: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), performClick: (item: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable function to display a list of actors.

#### Parameters

androidJvm

| | |
|---|---|
| actors | List of actors to display. |
| favActors | List of favorite actors. |
| addActorToFav | Callback to add an actor to favorites. |
| performClick | Callback to handle clicking on an actor item. |
