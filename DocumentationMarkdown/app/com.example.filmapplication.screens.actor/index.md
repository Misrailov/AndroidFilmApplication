//[app](../../index.md)/[com.example.filmapplication.screens.actor](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ActorApiState](-actor-api-state/index.md) | [androidJvm]<br>interface [ActorApiState](-actor-api-state/index.md)<br>Sealed interface defining possible states for the API calls related to actors. |
| [ActorListState](-actor-list-state/index.md) | [androidJvm]<br>data class [ActorListState](-actor-list-state/index.md)(val actorList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf(), val favouriteActors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf())<br>Represents the state of the actor list within the actor screen. |
| [ActorViewModel](-actor-view-model/index.md) | [androidJvm]<br>class [ActorViewModel](-actor-view-model/index.md)(actorRepository: [ActorRepository](../com.example.filmapplication.repository/-actor-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel class for managing actor-related data and UI states. |

## Functions

| Name | Summary |
|---|---|
| [ActorComposable](-actor-composable.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ActorComposable](-actor-composable.md)(addActorToFav: (item: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), actor: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md), isFavouriteActor: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), performClick: (item: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Composable function to display an actor item in a card. |
| [ActorList](-actor-list.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ActorList](-actor-list.md)(actors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;, favActors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;, addActorToFav: (item: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), performClick: (item: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Composable function to display a list of actors. |
| [ActorScreen](-actor-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ActorScreen](-actor-screen.md)(performClick: (id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), actorViewModel: [ActorViewModel](-actor-view-model/index.md) = viewModel(         factory = ActorViewModel.Factory     ))<br>Composable function to display a list of actors. |
