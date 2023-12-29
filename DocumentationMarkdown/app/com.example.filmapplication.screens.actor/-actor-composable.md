//[app](../../index.md)/[com.example.filmapplication.screens.actor](index.md)/[ActorComposable](-actor-composable.md)

# ActorComposable

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ActorComposable](-actor-composable.md)(addActorToFav: (item: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), actor: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md), isFavouriteActor: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), performClick: (item: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable function to display an actor item in a card.

#### Parameters

androidJvm

| | |
|---|---|
| addActorToFav | Callback to add an actor to favorites. |
| actor | The actor to display. |
| isFavouriteActor | Flag indicating if the actor is a favorite. |
| performClick | Callback to handle clicking on the actor item. |
