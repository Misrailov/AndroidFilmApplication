//[app](../../index.md)/[com.example.filmapplication.screens.actor](index.md)/[ActorScreen](-actor-screen.md)

# ActorScreen

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ActorScreen](-actor-screen.md)(performClick: (id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), actorViewModel: [ActorViewModel](-actor-view-model/index.md) = viewModel(
        factory = ActorViewModel.Factory
    ))

Composable function to display a list of actors.

#### Parameters

androidJvm

| | |
|---|---|
| performClick | Callback to handle clicking on an actor item. |
| actorViewModel | View model for managing actor-related data. |
