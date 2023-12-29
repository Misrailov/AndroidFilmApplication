//[app](../../../index.md)/[com.example.filmapplication.data.database.serie](../index.md)/[SerieDao](index.md)

# SerieDao

[androidJvm]\
interface [SerieDao](index.md)

Data Access Object (DAO) interface for interacting with the series database table.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [dbSerie](../db-serie/index.md))<br>Deletes a [dbSerie](../db-serie/index.md) item from the database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbSerie](../db-serie/index.md)&gt;&gt;<br>Retrieves all [dbSerie](../db-serie/index.md) items from the database, ordered by their title text in ascending order. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbSerie](../db-serie/index.md)&gt;<br>Retrieves a [dbSerie](../db-serie/index.md) item from the database based on its unique identifier [id](get-item.md). |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [dbSerie](../db-serie/index.md))<br>Inserts a [dbSerie](../db-serie/index.md) item into the database. If there is a conflict with an existing record, it replaces the existing record with the new one. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [dbSerie](../db-serie/index.md))<br>Updates an existing [dbSerie](../db-serie/index.md) item in the database. |
