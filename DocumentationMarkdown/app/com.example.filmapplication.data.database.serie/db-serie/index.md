//[app](../../../index.md)/[com.example.filmapplication.data.database.serie](../index.md)/[dbSerie](index.md)

# dbSerie

data class [dbSerie](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Represents a data class for a series entity in the Room database.

#### Parameters

androidJvm

| | |
|---|---|
| id | The unique identifier for the series. |
| primaryImage | The URL of the primary image for the series. |
| titleText | The title text of the series. |
| releaseYear | The release year of the series. |
| releaseDate | The release date of the series. |
| position | The position of the series. |
| isFavourite | Indicates whether the series is marked as a favorite. |

## Constructors

| | |
|---|---|
| [dbSerie](db-serie.md) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isFavourite](is-favourite.md) | [androidJvm]<br>val [isFavourite](is-favourite.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [position](position.md) | [androidJvm]<br>val [position](position.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [primaryImage](primary-image.md) | [androidJvm]<br>val [primaryImage](primary-image.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [releaseDate](release-date.md) | [androidJvm]<br>val [releaseDate](release-date.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [releaseYear](release-year.md) | [androidJvm]<br>val [releaseYear](release-year.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [titleText](title-text.md) | [androidJvm]<br>val [titleText](title-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [asDomainSerie](../as-domain-serie.md) | [androidJvm]<br>fun [dbSerie](index.md).[asDomainSerie](../as-domain-serie.md)(): [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)<br>Converts a [dbSerie](index.md) object into a [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md) object. |
