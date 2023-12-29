//[app](../../../index.md)/[com.example.filmapplication.model.actor](../index.md)/[ApiActor](index.md)

# ApiActor

[androidJvm]\
data class [ApiActor](index.md)(val nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Represents an actor retrieved from an API.

## Constructors

| | |
|---|---|
| [ApiActor](-api-actor.md) | [androidJvm]<br>constructor(nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [birthYear](birth-year.md) | [androidJvm]<br>val [birthYear](birth-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The birth year of the actor (default is &quot;0&quot; if unknown). |
| [deathYear](death-year.md) | [androidJvm]<br>val [deathYear](death-year.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The death year of the actor (default is &quot;0&quot; if alive or unknown). |
| [knownForTitles](known-for-titles.md) | [androidJvm]<br>val [knownForTitles](known-for-titles.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Titles for which the actor is known. |
| [nconst](nconst.md) | [androidJvm]<br>val [nconst](nconst.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The unique identifier for the actor. |
| [primaryName](primary-name.md) | [androidJvm]<br>val [primaryName](primary-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The primary name of the actor. |
| [primaryProfession](primary-profession.md) | [androidJvm]<br>val [primaryProfession](primary-profession.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The primary profession of the actor. |

## Functions

| Name | Summary |
|---|---|
| [asDomainActor](../as-domain-actor.md) | [androidJvm]<br>fun [ApiActor](index.md).[asDomainActor](../as-domain-actor.md)(): [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)<br>Converts an [ApiActor](index.md) object to a [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md) object. |
