//[app](../../index.md)/[com.example.filmapplication.network.movie](index.md)/[getFilmsAsFlow](get-films-as-flow.md)

# getFilmsAsFlow

[androidJvm]\
fun [FilmApiService](-film-api-service/index.md).[getFilmsAsFlow](get-films-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[FilmContainer](../com.example.filmapplication.model.film/-film-container/index.md)&gt;

Extension function to retrieve films as a Flow from [FilmApiService](-film-api-service/index.md).

#### Return

A Flow emitting a [FilmContainer](../com.example.filmapplication.model.film/-film-container/index.md) containing a list of films.

#### Parameters

androidJvm

| | |
|---|---|
| list | The list name for filtering films. |
| page | The page number for paginating results. |
| startYear | The start year for filtering films by release year. |
