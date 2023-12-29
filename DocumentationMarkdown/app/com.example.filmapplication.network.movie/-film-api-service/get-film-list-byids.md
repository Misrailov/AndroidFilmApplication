//[app](../../../index.md)/[com.example.filmapplication.network.movie](../index.md)/[FilmApiService](index.md)/[getFilmListByids](get-film-list-byids.md)

# getFilmListByids

[androidJvm]\

@GET(value = &quot;titles/x/titles-by-ids&quot;)

abstract suspend fun [getFilmListByids](get-film-list-byids.md)(@Query(value = &quot;idsList&quot;)idsList: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MultipleFilmsContainer](../../com.example.filmapplication.model.film/-multiple-films-container/index.md)

Retrieves a list of films by their IDs.

#### Return

A [MultipleFilmsContainer](../../com.example.filmapplication.model.film/-multiple-films-container/index.md) containing multiple films.

#### Parameters

androidJvm

| | |
|---|---|
| idsList | A comma-separated list of film IDs. |
