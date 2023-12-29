//[app](../../index.md)/[com.example.filmapplication.screens.film](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [FilmApiState](-film-api-state/index.md) | [androidJvm]<br>interface [FilmApiState](-film-api-state/index.md)<br>Represents the possible states of the film-related API calls. |
| [FilmListState](-film-list-state/index.md) | [androidJvm]<br>data class [FilmListState](-film-list-state/index.md)(val favouriteFilms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt; = listOf())<br>Represents the state of the film list, including favorite films. |
| [FilmViewModel](-film-view-model/index.md) | [androidJvm]<br>class [FilmViewModel](-film-view-model/index.md)(filmRepository: [FilmRepository](../com.example.filmapplication.repository/-film-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the Film screen. |

## Functions

| Name | Summary |
|---|---|
| [FilmComposable](-film-composable.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [FilmComposable](-film-composable.md)(film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md), addFilmToFavourites: (film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isOnActorPage: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Composable function for displaying an individual film item. |
| [FilmList](-film-list.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [FilmList](-film-list.md)(filmList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;? = listOf&lt;DomainFilm&gt;(), filmsPaged: [LazyPagingItems](https://developer.android.com/reference/kotlin/androidx/paging/compose/LazyPagingItems.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;? = null, addFilmToFavourites: (film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), favouriteFilms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;, isOnActorPage: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Composable function for displaying a list of films. |
| [FilmScreen](-film-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [FilmScreen](-film-screen.md)(filmViewModel: [FilmViewModel](-film-view-model/index.md) = viewModel(factory = FilmViewModel.Factory))<br>Composable function for displaying a list of films, including top-rated films, worst films, and other film-related content. |
