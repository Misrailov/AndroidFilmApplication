//[app](../../../index.md)/[com.example.filmapplication.data.database.film](../index.md)/[dbFilm](index.md)

# dbFilm

data class [dbFilm](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Data class representing a film entity in the database.

#### Parameters

androidJvm

| | |
|---|---|
| id | Unique identifier for the film. |
| primaryImage | The URL of the primary image associated with the film. |
| titleText | The title of the film. |
| releaseYear | The release year of the film. |
| releaseDate | The release date of the film. |
| position | The position of the film (if applicable). |
| isFavourite | Flag indicating if the film is a favorite. |

## Constructors

| | |
|---|---|
| [dbFilm](db-film.md) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

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
| [asDomainFilm](../as-domain-film.md) | [androidJvm]<br>fun [dbFilm](index.md).[asDomainFilm](../as-domain-film.md)(): [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)<br>Converts a [dbFilm](index.md) object to a [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md) object. |
