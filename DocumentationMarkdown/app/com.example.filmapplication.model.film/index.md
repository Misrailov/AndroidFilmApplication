//[app](../../index.md)/[com.example.filmapplication.model.film](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ApiFilm](-api-film/index.md) | [androidJvm]<br>data class [ApiFilm](-api-film/index.md)(val _id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryImage: [PrimaryImage](../[root]/-primary-image/index.md), val titleType: [TitleType](../[root]/-title-type/index.md), val titleText: [TitleText](../[root]/-title-text/index.md), val originalTitleText: [TitleText](../[root]/-title-text/index.md), val releaseYear: [YearRange](../[root]/-year-range/index.md), val releaseDate: [ReleaseDate](../[root]/-release-date/index.md)?, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?)<br>Represents a film retrieved from an API. |
| [FilmContainer](-film-container/index.md) | [androidJvm]<br>data class [FilmContainer](-film-container/index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;&quot;, val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiFilm](-api-film/index.md)&gt;)<br>Represents a container for a list of film data. |
| [FilmContainerSingular](-film-container-singular/index.md) | [androidJvm]<br>data class [FilmContainerSingular](-film-container-singular/index.md)(val results: [ApiFilm](-api-film/index.md))<br>Represents a container for a singular film result received from an API. |
| [MultipleFilmsContainer](-multiple-films-container/index.md) | [androidJvm]<br>data class [MultipleFilmsContainer](-multiple-films-container/index.md)(val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiFilm](-api-film/index.md)&gt;)<br>Represents a container for multiple film data entries. |

## Functions

| Name | Summary |
|---|---|
| [asDomainFilm](as-domain-film.md) | [androidJvm]<br>fun [ApiFilm](-api-film/index.md).[asDomainFilm](as-domain-film.md)(): [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md)<br>Converts an [ApiFilm](-api-film/index.md) object to a [DomainFilm](../com.example.filmapplication.domain/-domain-film/index.md) object. |
