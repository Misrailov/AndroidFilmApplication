//[app](../../index.md)/[com.example.filmapplication.screens.home](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [HomeApiState](-home-api-state/index.md) | [androidJvm]<br>interface [HomeApiState](-home-api-state/index.md)<br>Sealed interface representing the API states for the Home screen. |
| [HomeListState](-home-list-state/index.md) | [androidJvm]<br>data class [HomeListState](-home-list-state/index.md)(val films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt; = listOf(), val series: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md)&gt; = listOf(), val actors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf())<br>Data class representing the state of the Home screen lists. |
| [HomeViewModel](-home-view-model/index.md) | [androidJvm]<br>class [HomeViewModel](-home-view-model/index.md)(filmRepository: [FilmRepository](../com.example.filmapplication.repository/-film-repository/index.md), actorRepository: [ActorRepository](../com.example.filmapplication.repository/-actor-repository/index.md), serieRepository: [SerieRepository](../com.example.filmapplication.repository/-serie-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel class responsible for managing the Home screen state and data. |

## Functions

| Name | Summary |
|---|---|
| [HomeScreen](-home-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeScreen](-home-screen.md)(homeViewModel: [HomeViewModel](-home-view-model/index.md) = viewModel(factory = HomeViewModel.Factory), goToActor: (id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Composable function that displays the home screen with lists of favorite movies, series, and actors. |
