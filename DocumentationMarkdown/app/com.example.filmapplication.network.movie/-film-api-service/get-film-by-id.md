//[app](../../../index.md)/[com.example.filmapplication.network.movie](../index.md)/[FilmApiService](index.md)/[getFilmById](get-film-by-id.md)

# getFilmById

[androidJvm]\

@GET(value = &quot;titles/{id}&quot;)

abstract suspend fun [getFilmById](get-film-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FilmContainerSingular](../../com.example.filmapplication.model.film/-film-container-singular/index.md)

Retrieves a singular film by its unique identifier.

#### Return

A [FilmContainerSingular](../../com.example.filmapplication.model.film/-film-container-singular/index.md) containing a single film.

#### Parameters

androidJvm

| | |
|---|---|
| id | The unique identifier of the film. |
