//[app](../../../index.md)/[com.example.filmapplication.domain](../index.md)/[DomainActor](index.md)

# DomainActor

[androidJvm]\
data class [DomainActor](index.md)(val nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Represents an actor in the domain layer of the application.

## Constructors

| | |
|---|---|
| [DomainActor](-domain-actor.md) | [androidJvm]<br>constructor(nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [birthYear](birth-year.md) | [androidJvm]<br>val [birthYear](birth-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The birth year of the actor (default is &quot;0&quot; if unknown). |
| [deathYear](death-year.md) | [androidJvm]<br>val [deathYear](death-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The death year of the actor (default is &quot;0&quot; if alive or unknown). |
| [isFavourite](is-favourite.md) | [androidJvm]<br>var [isFavourite](is-favourite.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Flag indicating if the actor is marked as a favorite (default is false). |
| [knownForTitles](known-for-titles.md) | [androidJvm]<br>val [knownForTitles](known-for-titles.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Titles for which the actor is known. |
| [nconst](nconst.md) | [androidJvm]<br>val [nconst](nconst.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The unique identifier for the actor. |
| [primaryName](primary-name.md) | [androidJvm]<br>val [primaryName](primary-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The primary name of the actor. |
| [primaryProfession](primary-profession.md) | [androidJvm]<br>val [primaryProfession](primary-profession.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The primary profession of the actor. |

## Functions

| Name | Summary |
|---|---|
| [asDbActor](../../com.example.filmapplication.data.database.actor/as-db-actor.md) | [androidJvm]<br>fun [DomainActor](index.md).[asDbActor](../../com.example.filmapplication.data.database.actor/as-db-actor.md)(): [dbActor](../../com.example.filmapplication.data.database.actor/db-actor/index.md)<br>Converts a [DomainActor](index.md) object to a [dbActor](../../com.example.filmapplication.data.database.actor/db-actor/index.md) object. |
