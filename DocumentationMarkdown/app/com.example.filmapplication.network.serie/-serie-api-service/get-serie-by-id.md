//[app](../../../index.md)/[com.example.filmapplication.network.serie](../index.md)/[SerieApiService](index.md)/[getSerieById](get-serie-by-id.md)

# getSerieById

[androidJvm]\

@GET(value = &quot;titles/{id}&quot;)

abstract suspend fun [getSerieById](get-serie-by-id.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SerieContainerSingular](../../com.example.filmapplication.model.serie/-serie-container-singular/index.md)

Retrieves a singular series by its unique identifier.

#### Return

A [SerieContainerSingular](../../com.example.filmapplication.model.serie/-serie-container-singular/index.md) containing a single series.

#### Parameters

androidJvm

| | |
|---|---|
| id | The unique identifier of the series. |
