//[app](../../index.md)/[com.example.filmapplication.network.movie](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [FilmApiService](-film-api-service/index.md) | [androidJvm]<br>interface [FilmApiService](-film-api-service/index.md)<br>Retrofit service interface for fetching film-related data from an API. |

## Functions

| Name | Summary |
|---|---|
| [getFilmsAsFlow](get-films-as-flow.md) | [androidJvm]<br>fun [FilmApiService](-film-api-service/index.md).[getFilmsAsFlow](get-films-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[FilmContainer](../com.example.filmapplication.model.film/-film-container/index.md)&gt;<br>Extension function to retrieve films as a Flow from [FilmApiService](-film-api-service/index.md). |
