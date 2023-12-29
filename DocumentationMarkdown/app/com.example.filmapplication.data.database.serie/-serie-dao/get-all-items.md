//[app](../../../index.md)/[com.example.filmapplication.data.database.serie](../index.md)/[SerieDao](index.md)/[getAllItems](get-all-items.md)

# getAllItems

[androidJvm]\
abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbSerie](../db-serie/index.md)&gt;&gt;

Retrieves all [dbSerie](../db-serie/index.md) items from the database, ordered by their title text in ascending order.

#### Return

A Flow of a list of [dbSerie](../db-serie/index.md) objects representing all items in the database.
