//[app](../../../index.md)/[com.example.filmapplication.data.database.serie](../index.md)/[SerieDao](index.md)/[getItem](get-item.md)

# getItem

[androidJvm]\
abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbSerie](../db-serie/index.md)&gt;

Retrieves a [dbSerie](../db-serie/index.md) item from the database based on its unique identifier [id](get-item.md).

#### Return

A Flow of [dbSerie](../db-serie/index.md) representing the retrieved item, or an empty Flow if not found.

#### Parameters

androidJvm

| | |
|---|---|
| id | The unique identifier of the [dbSerie](../db-serie/index.md) item to retrieve. |
