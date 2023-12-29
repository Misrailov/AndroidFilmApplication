//[app](../../../index.md)/[com.example.filmapplication.model.serie](../index.md)/[SerieContainer](index.md)

# SerieContainer

[androidJvm]\
data class [SerieContainer](index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiSerie](../-api-serie/index.md)&gt;)

Represents a container for a list of series data.

## Constructors

| | |
|---|---|
| [SerieContainer](-serie-container.md) | [androidJvm]<br>constructor(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiSerie](../-api-serie/index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [androidJvm]<br>val [entries](entries.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The number of entries in the container. |
| [next](next.md) | [androidJvm]<br>val [next](next.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The URL of the next page, if available. |
| [page](page.md) | [androidJvm]<br>val [page](page.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The page number associated with the data. |
| [results](results.md) | [androidJvm]<br>val [results](results.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiSerie](../-api-serie/index.md)&gt;<br>The list of [ApiSerie](../-api-serie/index.md) objects contained in the container. |
