//[app](../../index.md)/[com.example.filmapplication.screens.actor.ActorDetails](index.md)/[ActorDetailScreen](-actor-detail-screen.md)

# ActorDetailScreen

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ActorDetailScreen](-actor-detail-screen.md)(actorId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, actorDetailViewModel: [ActorDetailViewModel](-actor-detail-view-model/index.md) = viewModel(factory = ActorDetailViewModel.Factory))

Composable function that displays detailed information about an actor, including their image, name, birth and death years, and a list of films they are known for.

#### Parameters

androidJvm

| | |
|---|---|
| actorId | The ID of the actor to retrieve details for. |
| actorDetailViewModel | The ViewModel responsible for fetching actor details. |
