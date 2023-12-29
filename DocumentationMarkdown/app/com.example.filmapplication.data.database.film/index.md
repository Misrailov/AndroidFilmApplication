//[app](../../index.md)/[com.example.filmapplication.data.database.film](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [dbFilm](db-film/index.md) | [androidJvm]<br>data class [dbFilm](db-film/index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Data class representing a film entity in the database. |
| [FilmDao](-film-dao/index.md) | [androidJvm]<br>interface [FilmDao](-film-dao/index.md)<br>Data Access Object (DAO) interface for managing films in the database. |

## Functions

| Name | Summary |
|---|---|
| [asDbFilm](as-db-film.md) | [androidJvm]<br>fun [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md).[asDbFilm](as-db-film.md)(): [dbFilm](db-film/index.md)<br>Converts a [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md) object to a [dbFilm](db-film/index.md) object. |
| [asDomainFilm](as-domain-film.md) | [androidJvm]<br>fun [dbFilm](db-film/index.md).[asDomainFilm](as-domain-film.md)(): [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)<br>Converts a [dbFilm](db-film/index.md) object to a [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md) object.<br>[androidJvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbFilm](db-film/index.md)&gt;.[asDomainFilm](as-domain-film.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Converts a list of [dbFilm](db-film/index.md) objects to a list of [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md) objects. |
