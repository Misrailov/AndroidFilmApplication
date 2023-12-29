//[app](../../../index.md)/[com.example.filmapplication.domain](../index.md)/[DomainSerie](index.md)

# DomainSerie

[androidJvm]\
data class [DomainSerie](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, var isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Represents a series in the domain layer of the application.

## Constructors

| | |
|---|---|
| [DomainSerie](-domain-serie.md) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The unique identifier for the series. |
| [isFavourite](is-favourite.md) | [androidJvm]<br>var [isFavourite](is-favourite.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Flag indicating if the series is marked as a favorite (default is false). |
| [position](position.md) | [androidJvm]<br>val [position](position.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>The position of the series (default is 0 if not specified). |
| [primaryImage](primary-image.md) | [androidJvm]<br>val [primaryImage](primary-image.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The URL of the primary image associated with the series. |
| [releaseDate](release-date.md) | [androidJvm]<br>val [releaseDate](release-date.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The release date of the series. |
| [releaseYear](release-year.md) | [androidJvm]<br>val [releaseYear](release-year.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>The release year of the series (default is 0 if unknown). |
| [titleText](title-text.md) | [androidJvm]<br>val [titleText](title-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The title of the series. |

## Functions

| Name | Summary |
|---|---|
| [asDbSerie](../../com.example.filmapplication.data.database.serie/as-db-serie.md) | [androidJvm]<br>fun [DomainSerie](index.md).[asDbSerie](../../com.example.filmapplication.data.database.serie/as-db-serie.md)(): [dbSerie](../../com.example.filmapplication.data.database.serie/db-serie/index.md)<br>Converts a [DomainSerie](index.md) object into a [dbSerie](../../com.example.filmapplication.data.database.serie/db-serie/index.md) object. |
