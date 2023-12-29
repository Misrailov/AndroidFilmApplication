//[app](../../../index.md)/[com.example.filmapplication.data.database.film](../index.md)/[FilmDao](index.md)

# FilmDao

[androidJvm]\
interface [FilmDao](index.md)

Data Access Object (DAO) interface for managing films in the database.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [dbFilm](../db-film/index.md))<br>Deletes a film from the database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbFilm](../db-film/index.md)&gt;&gt;<br>Retrieves all films in the database, ordered by title text. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbFilm](../db-film/index.md)&gt;<br>Retrieves a film by its unique identifier. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [dbFilm](../db-film/index.md))<br>Inserts or replaces a film in the database. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [dbFilm](../db-film/index.md))<br>Updates an existing film in the database. |
