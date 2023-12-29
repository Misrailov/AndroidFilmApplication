//[app](../../../index.md)/[com.example.filmapplication.data.database.actor](../index.md)/[ActorDao](index.md)/[getFavourites](get-favourites.md)

# getFavourites

[androidJvm]\
abstract fun [getFavourites](get-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbActor](../db-actor/index.md)&gt;&gt;

Retrieves all favorite actors from the database, ordered by primary name in ascending order.

#### Return

A Flow emitting a list of favorite actors.
