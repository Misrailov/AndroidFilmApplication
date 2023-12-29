//[app](../../index.md)/[com.example.filmapplication.screens.film](index.md)/[FilmComposable](-film-composable.md)

# FilmComposable

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FilmComposable](-film-composable.md)(film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md), addFilmToFavourites: (film: [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isOnActorPage: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Composable function for displaying an individual film item.

#### Parameters

androidJvm

| | |
|---|---|
| film | The film to display. |
| addFilmToFavourites | Function to add a film to favorites. |
| isFavourite | Boolean indicating whether the film is in the user's favorites. |
