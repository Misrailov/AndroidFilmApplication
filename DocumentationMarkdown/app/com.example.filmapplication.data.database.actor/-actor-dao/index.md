//[app](../../../index.md)/[com.example.filmapplication.data.database.actor](../index.md)/[ActorDao](index.md)

# ActorDao

[androidJvm]\
interface [ActorDao](index.md)

Data Access Object (DAO) interface for managing actors in the database.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [dbActor](../db-actor/index.md))<br>Deletes an actor from the database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbActor](../db-actor/index.md)&gt;&gt;<br>Retrieves all actors in the database, ordered by primary name in ascending order. |
| [getFavourites](get-favourites.md) | [androidJvm]<br>abstract fun [getFavourites](get-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbActor](../db-actor/index.md)&gt;&gt;<br>Retrieves all favorite actors from the database, ordered by primary name in ascending order. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbActor](../db-actor/index.md)&gt;<br>Retrieves an actor by their primary name. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [dbActor](../db-actor/index.md))<br>Inserts or replaces an actor in the database. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [dbActor](../db-actor/index.md))<br>Updates an existing actor in the database. |
