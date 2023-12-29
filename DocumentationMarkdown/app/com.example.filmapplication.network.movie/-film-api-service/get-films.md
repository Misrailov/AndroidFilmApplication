//[app](../../../index.md)/[com.example.filmapplication.network.movie](../index.md)/[FilmApiService](index.md)/[getFilms](get-films.md)

# getFilms

[androidJvm]\

@GET(value = &quot;titles&quot;)

abstract suspend fun [getFilms](get-films.md)(@Query(value = &quot;list&quot;)list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;startYear&quot;)startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [FilmContainer](../../com.example.filmapplication.model.film/-film-container/index.md)

Retrieves a list of films based on specified parameters.

#### Return

A [FilmContainer](../../com.example.filmapplication.model.film/-film-container/index.md) containing a list of films.

#### Parameters

androidJvm

| | |
|---|---|
| list | The list name for filtering films. |
| page | The page number for paginating results. |
| startYear | The start year for filtering films by release year. |
