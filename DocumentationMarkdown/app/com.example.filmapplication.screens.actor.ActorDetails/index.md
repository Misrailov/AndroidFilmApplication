//[app](../../index.md)/[com.example.filmapplication.screens.actor.ActorDetails](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ActorDetailViewModel](-actor-detail-view-model/index.md) | [androidJvm]<br>class [ActorDetailViewModel](-actor-detail-view-model/index.md)(actorRepository: [ActorRepository](../com.example.filmapplication.repository/-actor-repository/index.md), filmRepository: [FilmRepository](../com.example.filmapplication.repository/-film-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel class for the Actor Detail screen. |
| [ActorDetailViewUiState](-actor-detail-view-ui-state/index.md) | [androidJvm]<br>interface [ActorDetailViewUiState](-actor-detail-view-ui-state/index.md)<br>Represents the possible UI states for the Actor Detail screen. |

## Functions

| Name | Summary |
|---|---|
| [ActorDetailScreen](-actor-detail-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ActorDetailScreen](-actor-detail-screen.md)(actorId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, actorDetailViewModel: [ActorDetailViewModel](-actor-detail-view-model/index.md) = viewModel(factory = ActorDetailViewModel.Factory))<br>Composable function that displays detailed information about an actor, including their image, name, birth and death years, and a list of films they are known for. |
| [ActorHeader](-actor-header.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ActorHeader](-actor-header.md)(actor: [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md))<br>Composable function to display the header section of an actor's details, including their image, name, birth and death years. |
