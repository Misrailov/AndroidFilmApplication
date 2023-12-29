//[app](../../../index.md)/[com.example.filmapplication.model.film](../index.md)/[ApiFilm](index.md)

# ApiFilm

[androidJvm]\
data class [ApiFilm](index.md)(val _id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryImage: [PrimaryImage](../../[root]/-primary-image/index.md), val titleType: [TitleType](../../[root]/-title-type/index.md), val titleText: [TitleText](../../[root]/-title-text/index.md), val originalTitleText: [TitleText](../../[root]/-title-text/index.md), val releaseYear: [YearRange](../../[root]/-year-range/index.md), val releaseDate: [ReleaseDate](../../[root]/-release-date/index.md)?, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?)

Represents a film retrieved from an API.

## Constructors

| | |
|---|---|
| [ApiFilm](-api-film.md) | [androidJvm]<br>constructor(_id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), primaryImage: [PrimaryImage](../../[root]/-primary-image/index.md), titleType: [TitleType](../../[root]/-title-type/index.md), titleText: [TitleText](../../[root]/-title-text/index.md), originalTitleText: [TitleText](../../[root]/-title-text/index.md), releaseYear: [YearRange](../../[root]/-year-range/index.md), releaseDate: [ReleaseDate](../../[root]/-release-date/index.md)?, position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [_id](_id.md) | [androidJvm]<br>val [_id](_id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The unique identifier for the film. |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The ID of the film. |
| [originalTitleText](original-title-text.md) | [androidJvm]<br>val [originalTitleText](original-title-text.md): [TitleText](../../[root]/-title-text/index.md)<br>The original text of the film's title. |
| [position](position.md) | [androidJvm]<br>val [position](position.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?<br>The position of the film. |
| [primaryImage](primary-image.md) | [androidJvm]<br>val [primaryImage](primary-image.md): [PrimaryImage](../../[root]/-primary-image/index.md)<br>The URL of the primary image associated with the film. |
| [releaseDate](release-date.md) | [androidJvm]<br>val [releaseDate](release-date.md): [ReleaseDate](../../[root]/-release-date/index.md)?<br>The release date of the film. |
| [releaseYear](release-year.md) | [androidJvm]<br>val [releaseYear](release-year.md): [YearRange](../../[root]/-year-range/index.md)<br>The release year of the film. |
| [titleText](title-text.md) | [androidJvm]<br>val [titleText](title-text.md): [TitleText](../../[root]/-title-text/index.md)<br>The text of the film's title. |
| [titleType](title-type.md) | [androidJvm]<br>val [titleType](title-type.md): [TitleType](../../[root]/-title-type/index.md)<br>The type of the film's title. |

## Functions

| Name | Summary |
|---|---|
| [asDomainFilm](../as-domain-film.md) | [androidJvm]<br>fun [ApiFilm](index.md).[asDomainFilm](../as-domain-film.md)(): [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)<br>Converts an [ApiFilm](index.md) object to a [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md) object. |
