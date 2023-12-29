//[app](../../index.md)/[com.example.filmapplication.network.serie](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SerieApiService](-serie-api-service/index.md) | [androidJvm]<br>interface [SerieApiService](-serie-api-service/index.md)<br>Retrofit service interface for fetching series-related data from an API. |

## Functions

| Name | Summary |
|---|---|
| [getSeriesAsFlow](get-series-as-flow.md) | [androidJvm]<br>fun [SerieApiService](-serie-api-service/index.md).[getSeriesAsFlow](get-series-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[SerieContainer](../com.example.filmapplication.model.serie/-serie-container/index.md)&gt;<br>Extension function to retrieve series as a Flow from [SerieApiService](-serie-api-service/index.md). |
