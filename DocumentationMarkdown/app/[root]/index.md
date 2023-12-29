//[app](../../index.md)/[[root]](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Caption](-caption/index.md) | [androidJvm]<br>data class [Caption](-caption/index.md)(val plainText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val __typename: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Represents the caption for an image. |
| [FilmPagingSource](-film-paging-source/index.md) | [androidJvm]<br>class [FilmPagingSource](-film-paging-source/index.md)(val filmRepository: [FilmRepository](../com.example.filmapplication.repository/-film-repository/index.md), val query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt; <br>A [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) for loading paged data of films from a [FilmRepository](../com.example.filmapplication.repository/-film-repository/index.md). |
| [PrimaryImage](-primary-image/index.md) | [androidJvm]<br>data class [PrimaryImage](-primary-image/index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val caption: [Caption](-caption/index.md))<br>Represents the primary image associated with a title. |
| [ReleaseDate](-release-date/index.md) | [androidJvm]<br>data class [ReleaseDate](-release-date/index.md)(val day: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = 0, val month: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = 0, val year: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = 0, val __typename: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)<br>Represents a release date. |
| [TitleText](-title-text/index.md) | [androidJvm]<br>data class [TitleText](-title-text/index.md)(val text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val __typename: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)<br>Represents the text of a title. |
| [TitleType](-title-type/index.md) | [androidJvm]<br>data class [TitleType](-title-type/index.md)(val text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val isSeries: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val isEpisode: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val __typename: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)<br>Represents the type of a title. |
| [YearRange](-year-range/index.md) | [androidJvm]<br>data class [YearRange](-year-range/index.md)(val year: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val endYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = 0, val __typename: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)<br>Represents a year range. |

## Properties

| Name | Summary |
|---|---|
| [Typography](-typography.md) | [androidJvm]<br>val [Typography](-typography.md): [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) |
