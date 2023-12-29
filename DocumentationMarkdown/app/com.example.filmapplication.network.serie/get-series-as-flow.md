//[app](../../index.md)/[com.example.filmapplication.network.serie](index.md)/[getSeriesAsFlow](get-series-as-flow.md)

# getSeriesAsFlow

[androidJvm]\
fun [SerieApiService](-serie-api-service/index.md).[getSeriesAsFlow](get-series-as-flow.md)(list: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), startYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[SerieContainer](../com.example.filmapplication.model.serie/-serie-container/index.md)&gt;

Extension function to retrieve series as a Flow from [SerieApiService](-serie-api-service/index.md).

#### Return

A Flow emitting a [SerieContainer](../com.example.filmapplication.model.serie/-serie-container/index.md) containing a list of series.

#### Parameters

androidJvm

| | |
|---|---|
| list | The list name for filtering series. |
| page | The page number for paginating results. |
| startYear | The start year for filtering series by release year. |
