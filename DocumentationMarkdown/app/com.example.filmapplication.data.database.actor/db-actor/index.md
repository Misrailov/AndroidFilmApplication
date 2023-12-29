//[app](../../../index.md)/[com.example.filmapplication.data.database.actor](../index.md)/[dbActor](index.md)

# dbActor

data class [dbActor](index.md)(val nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Data class representing an actor entity in the database.

#### Parameters

androidJvm

| | |
|---|---|
| nconst | Unique identifier for the actor. |
| primaryName | The primary name of the actor. |
| birthYear | The birth year of the actor. |
| deathYear | The death year of the actor. |
| primaryProfession | The primary profession of the actor. |
| knownForTitles | Titles the actor is known for. |
| isFavourite | Flag indicating if the actor is a favorite. |

## Constructors

| | |
|---|---|
| [dbActor](db-actor.md) | [androidJvm]<br>constructor(nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [birthYear](birth-year.md) | [androidJvm]<br>val [birthYear](birth-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [deathYear](death-year.md) | [androidJvm]<br>val [deathYear](death-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isFavourite](is-favourite.md) | [androidJvm]<br>val [isFavourite](is-favourite.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [knownForTitles](known-for-titles.md) | [androidJvm]<br>val [knownForTitles](known-for-titles.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [nconst](nconst.md) | [androidJvm]<br>val [nconst](nconst.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [primaryName](primary-name.md) | [androidJvm]<br>val [primaryName](primary-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [primaryProfession](primary-profession.md) | [androidJvm]<br>val [primaryProfession](primary-profession.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [asDomainActor](../as-domain-actor.md) | [androidJvm]<br>fun [dbActor](index.md).[asDomainActor](../as-domain-actor.md)(): [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)<br>Converts a [dbActor](index.md) object to a [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md) object. |
