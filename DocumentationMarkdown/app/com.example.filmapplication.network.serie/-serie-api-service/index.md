//[app](../../../index.md)/[com.example.filmapplication.network.serie](../index.md)/[SerieApiService](index.md)

# SerieApiService

[androidJvm]\
interface [SerieApiService](index.md)

Retrofit service interface for fetching series-related data from an API.

## Functions

| Name | Summary |
|---|---|
| [getSerieById](get-serie-by-id.md) | [androidJvm]<br>@GET(value = &quot;titles/{id}&quot;)<br>abstract suspend fun [getSerieById](get-serie-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SerieContainerSingular](../../com.example.filmapplication.model.serie/-serie-container-singular/index.md)<br>Retrieves a singular series by its unique identifier. |
| [getSeries](get-series.md) | [androidJvm]<br>@GET(value = &quot;titles&quot;)<br>abstract suspend fun [getSeries](get-series.md)(@Query(value = &quot;list&quot;)list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;startYear&quot;)startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SerieContainer](../../com.example.filmapplication.model.serie/-serie-container/index.md)<br>Retrieves a list of series based on specified parameters. |
| [getSeriesAsFlow](../get-series-as-flow.md) | [androidJvm]<br>fun [SerieApiService](index.md).[getSeriesAsFlow](../get-series-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[SerieContainer](../../com.example.filmapplication.model.serie/-serie-container/index.md)&gt;<br>Extension function to retrieve series as a Flow from [SerieApiService](index.md). |
