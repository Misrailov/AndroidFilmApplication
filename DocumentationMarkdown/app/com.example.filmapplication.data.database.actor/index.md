//[app](../../index.md)/[com.example.filmapplication.data.database.actor](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ActorDao](-actor-dao/index.md) | [androidJvm]<br>interface [ActorDao](-actor-dao/index.md)<br>Data Access Object (DAO) interface for managing actors in the database. |
| [dbActor](db-actor/index.md) | [androidJvm]<br>data class [dbActor](db-actor/index.md)(val nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Data class representing an actor entity in the database. |

## Functions

| Name | Summary |
|---|---|
| [asDbActor](as-db-actor.md) | [androidJvm]<br>fun [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md).[asDbActor](as-db-actor.md)(): [dbActor](db-actor/index.md)<br>Converts a [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) object to a [dbActor](db-actor/index.md) object. |
| [asDomainActor](as-domain-actor.md) | [androidJvm]<br>fun [dbActor](db-actor/index.md).[asDomainActor](as-domain-actor.md)(): [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)<br>Converts a [dbActor](db-actor/index.md) object to a [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) object. |
| [asDomainActors](as-domain-actors.md) | [androidJvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbActor](db-actor/index.md)&gt;.[asDomainActors](as-domain-actors.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>Converts a list of [dbActor](db-actor/index.md) objects to a list of [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) objects. |
