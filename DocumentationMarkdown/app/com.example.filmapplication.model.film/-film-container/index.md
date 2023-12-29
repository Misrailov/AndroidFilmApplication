//[app](../../../index.md)/[com.example.filmapplication.model.film](../index.md)/[FilmContainer](index.md)

# FilmContainer

[androidJvm]\
data class [FilmContainer](index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiFilm](../-api-film/index.md)&gt;)

Represents a container for a list of film data.

## Constructors

| | |
|---|---|
| [FilmContainer](-film-container.md) | [androidJvm]<br>constructor(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiFilm](../-api-film/index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [androidJvm]<br>val [entries](entries.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The number of entries in the container. |
| [next](next.md) | [androidJvm]<br>val [next](next.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The URL of the next page, if available. |
| [page](page.md) | [androidJvm]<br>val [page](page.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The page number associated with the data. |
| [results](results.md) | [androidJvm]<br>val [results](results.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiFilm](../-api-film/index.md)&gt;<br>The list of [ApiFilm](../-api-film/index.md) objects contained in the container. |
