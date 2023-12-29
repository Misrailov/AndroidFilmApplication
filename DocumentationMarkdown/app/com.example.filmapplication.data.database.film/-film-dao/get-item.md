//[app](../../../index.md)/[com.example.filmapplication.data.database.film](../index.md)/[FilmDao](index.md)/[getItem](get-item.md)

# getItem

[androidJvm]\
abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbFilm](../db-film/index.md)&gt;

Retrieves a film by its unique identifier.

#### Return

A Flow emitting the film with the specified ID.

#### Parameters

androidJvm

| | |
|---|---|
| id | The unique identifier of the film to retrieve. |
