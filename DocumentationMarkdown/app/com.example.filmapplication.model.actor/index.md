//[app](../../index.md)/[com.example.filmapplication.model.actor](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ActorContainer](-actor-container/index.md) | [androidJvm]<br>data class [ActorContainer](-actor-container/index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](-api-actor/index.md)&gt;)<br>Represents a container for a list of actor data. |
| [ActorContainerSingular](-actor-container-singular/index.md) | [androidJvm]<br>data class [ActorContainerSingular](-actor-container-singular/index.md)(val results: [ApiActor](-api-actor/index.md))<br>Represents a container for a singular actor data. |
| [ApiActor](-api-actor/index.md) | [androidJvm]<br>data class [ApiActor](-api-actor/index.md)(val nconst: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val deathYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;0&quot;, val primaryProfession: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val knownForTitles: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Represents an actor retrieved from an API. |

## Functions

| Name | Summary |
|---|---|
| [asDomainActor](as-domain-actor.md) | [androidJvm]<br>fun [ApiActor](-api-actor/index.md).[asDomainActor](as-domain-actor.md)(): [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)<br>Converts an [ApiActor](-api-actor/index.md) object to a [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) object. |
| [asDomainActors](as-domain-actors.md) | [androidJvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](-api-actor/index.md)&gt;.[asDomainActors](as-domain-actors.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;<br>Converts a list of [ApiActor](-api-actor/index.md) objects to a list of [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) objects.<br>[androidJvm]<br>fun Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](-api-actor/index.md)&gt;&gt;.[asDomainActors](as-domain-actors.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md)&gt;&gt;<br>Converts a Flow of lists of [ApiActor](-api-actor/index.md) objects to a Flow of lists of [DomainActor](../com.example.filmapplication.domain/-domain-actor/index.md) objects. |
| [getList](get-list.md) | [androidJvm]<br>fun [ActorContainer](-actor-container/index.md).[getList](get-list.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](-api-actor/index.md)&gt;<br>Extracts a list of [ApiActor](-api-actor/index.md) objects from the [ActorContainer](-actor-container/index.md). |
