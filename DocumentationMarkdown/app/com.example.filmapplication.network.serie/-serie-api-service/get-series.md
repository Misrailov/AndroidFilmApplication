//[app](../../../index.md)/[com.example.filmapplication.network.serie](../index.md)/[SerieApiService](index.md)/[getSeries](get-series.md)

# getSeries

[androidJvm]\

@GET(value = &quot;titles&quot;)

abstract suspend fun [getSeries](get-series.md)(@Query(value = &quot;list&quot;)list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;startYear&quot;)startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SerieContainer](../../com.example.filmapplication.model.serie/-serie-container/index.md)

Retrieves a list of series based on specified parameters.

#### Return

A [SerieContainer](../../com.example.filmapplication.model.serie/-serie-container/index.md) containing a list of series.

#### Parameters

androidJvm

| | |
|---|---|
| list | The list name for filtering series. |
| page | The page number for paginating results. |
| startYear | The start year for filtering series by release year. |
