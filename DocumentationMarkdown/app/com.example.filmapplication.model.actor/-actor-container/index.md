//[app](../../../index.md)/[com.example.filmapplication.model.actor](../index.md)/[ActorContainer](index.md)

# ActorContainer

[androidJvm]\
data class [ActorContainer](index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](../-api-actor/index.md)&gt;)

Represents a container for a list of actor data.

## Constructors

| | |
|---|---|
| [ActorContainer](-actor-container.md) | [androidJvm]<br>constructor(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](../-api-actor/index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [androidJvm]<br>val [entries](entries.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The number of entries in the container. |
| [next](next.md) | [androidJvm]<br>val [next](next.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The next page URL, if available. |
| [page](page.md) | [androidJvm]<br>val [page](page.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>The page number associated with the data (default is 0). |
| [results](results.md) | [androidJvm]<br>val [results](results.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](../-api-actor/index.md)&gt;<br>The list of [ApiActor](../-api-actor/index.md) objects contained in the container. |

## Functions

| Name | Summary |
|---|---|
| [getList](../get-list.md) | [androidJvm]<br>fun [ActorContainer](index.md).[getList](../get-list.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiActor](../-api-actor/index.md)&gt;<br>Extracts a list of [ApiActor](../-api-actor/index.md) objects from the [ActorContainer](index.md). |
