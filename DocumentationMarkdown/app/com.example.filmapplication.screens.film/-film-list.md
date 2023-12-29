//[app](../../index.md)/[com.example.filmapplication.screens.film](index.md)/[FilmList](-film-list.md)

# FilmList

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FilmList](-film-list.md)(filmList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;? = listOf&lt;DomainFilm&gt;(), filmsPaged: [LazyPagingItems](https://developer.android.com/reference/kotlin/androidx/paging/compose/LazyPagingItems.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;? = null, addFilmToFavourites: (film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), favouriteFilms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;, isOnActorPage: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Composable function for displaying a list of films.

#### Parameters

androidJvm

| | |
|---|---|
| filmList | A list of films to display. |
| filmsPaged | LazyPagingItems containing films to display (optional, if using paging). |
| addFilmToFavourites | Function to add a film to favorites. |
| favouriteFilms | List of favorite films. |
