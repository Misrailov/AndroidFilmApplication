//[app](../../../index.md)/[com.example.filmapplication.network.movie](../index.md)/[FilmApiService](index.md)

# FilmApiService

[androidJvm]\
interface [FilmApiService](index.md)

Retrofit service interface for fetching film-related data from an API.

## Functions

| Name | Summary |
|---|---|
| [getFilmById](get-film-by-id.md) | [androidJvm]<br>@GET(value = &quot;titles/{id}&quot;)<br>abstract suspend fun [getFilmById](get-film-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FilmContainerSingular](../../com.example.filmapplication.model.film/-film-container-singular/index.md)<br>Retrieves a singular film by its unique identifier. |
| [getFilmListByids](get-film-list-byids.md) | [androidJvm]<br>@GET(value = &quot;titles/x/titles-by-ids&quot;)<br>abstract suspend fun [getFilmListByids](get-film-list-byids.md)(@Query(value = &quot;idsList&quot;)idsList: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MultipleFilmsContainer](../../com.example.filmapplication.model.film/-multiple-films-container/index.md)<br>Retrieves a list of films by their IDs. |
| [getFilms](get-films.md) | [androidJvm]<br>@GET(value = &quot;titles&quot;)<br>abstract suspend fun [getFilms](get-films.md)(@Query(value = &quot;list&quot;)list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;startYear&quot;)startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [FilmContainer](../../com.example.filmapplication.model.film/-film-container/index.md)<br>Retrieves a list of films based on specified parameters. |
| [getFilmsAsFlow](../get-films-as-flow.md) | [androidJvm]<br>fun [FilmApiService](index.md).[getFilmsAsFlow](../get-films-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[FilmContainer](../../com.example.filmapplication.model.film/-film-container/index.md)&gt;<br>Extension function to retrieve films as a Flow from [FilmApiService](index.md). |
