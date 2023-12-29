//[app](../../../index.md)/[com.example.filmapplication.model.serie](../index.md)/[ApiSerie](index.md)

# ApiSerie

[androidJvm]\
data class [ApiSerie](index.md)(val _id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryImage: [PrimaryImage](../../[root]/-primary-image/index.md), val titleType: [TitleType](../../[root]/-title-type/index.md), val titleText: [TitleText](../../[root]/-title-text/index.md), val originalTitleText: [TitleText](../../[root]/-title-text/index.md), val releaseYear: [YearRange](../../[root]/-year-range/index.md), val releaseDate: [ReleaseDate](../../[root]/-release-date/index.md))

Represents a series retrieved from an API.

## Constructors

| | |
|---|---|
| [ApiSerie](-api-serie.md) | [androidJvm]<br>constructor(_id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), primaryImage: [PrimaryImage](../../[root]/-primary-image/index.md), titleType: [TitleType](../../[root]/-title-type/index.md), titleText: [TitleText](../../[root]/-title-text/index.md), originalTitleText: [TitleText](../../[root]/-title-text/index.md), releaseYear: [YearRange](../../[root]/-year-range/index.md), releaseDate: [ReleaseDate](../../[root]/-release-date/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [_id](_id.md) | [androidJvm]<br>val [_id](_id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The unique identifier for the series. |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The ID of the series. |
| [originalTitleText](original-title-text.md) | [androidJvm]<br>val [originalTitleText](original-title-text.md): [TitleText](../../[root]/-title-text/index.md)<br>The original text of the series title. |
| [primaryImage](primary-image.md) | [androidJvm]<br>val [primaryImage](primary-image.md): [PrimaryImage](../../[root]/-primary-image/index.md)<br>The URL of the primary image associated with the series. |
| [releaseDate](release-date.md) | [androidJvm]<br>val [releaseDate](release-date.md): [ReleaseDate](../../[root]/-release-date/index.md)<br>The release date of the series. |
| [releaseYear](release-year.md) | [androidJvm]<br>val [releaseYear](release-year.md): [YearRange](../../[root]/-year-range/index.md)<br>The release year of the series. |
| [titleText](title-text.md) | [androidJvm]<br>val [titleText](title-text.md): [TitleText](../../[root]/-title-text/index.md)<br>The text of the series title. |
| [titleType](title-type.md) | [androidJvm]<br>val [titleType](title-type.md): [TitleType](../../[root]/-title-type/index.md)<br>The type of the series title. |

## Functions

| Name | Summary |
|---|---|
| [asDomainSerie](../as-domain-serie.md) | [androidJvm]<br>fun [ApiSerie](index.md).[asDomainSerie](../as-domain-serie.md)(): [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)<br>Converts an [ApiSerie](index.md) object to a [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md) object. |
