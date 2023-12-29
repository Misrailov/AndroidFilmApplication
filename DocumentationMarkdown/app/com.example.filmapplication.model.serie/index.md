//[app](../../index.md)/[com.example.filmapplication.model.serie](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ApiSerie](-api-serie/index.md) | [androidJvm]<br>data class [ApiSerie](-api-serie/index.md)(val _id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val primaryImage: [PrimaryImage](../[root]/-primary-image/index.md), val titleType: [TitleType](../[root]/-title-type/index.md), val titleText: [TitleText](../[root]/-title-text/index.md), val originalTitleText: [TitleText](../[root]/-title-text/index.md), val releaseYear: [YearRange](../[root]/-year-range/index.md), val releaseDate: [ReleaseDate](../[root]/-release-date/index.md))<br>Represents a series retrieved from an API. |
| [SerieContainer](-serie-container/index.md) | [androidJvm]<br>data class [SerieContainer](-serie-container/index.md)(val page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val next: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val entries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiSerie](-api-serie/index.md)&gt;)<br>Represents a container for a list of series data. |
| [SerieContainerSingular](-serie-container-singular/index.md) | [androidJvm]<br>data class [SerieContainerSingular](-serie-container-singular/index.md)(val results: [ApiSerie](-api-serie/index.md))<br>Represents a container for a singular series result received from an API. |

## Functions

| Name | Summary |
|---|---|
| [asDomainSerie](as-domain-serie.md) | [androidJvm]<br>fun [ApiSerie](-api-serie/index.md).[asDomainSerie](as-domain-serie.md)(): [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md)<br>Converts an [ApiSerie](-api-serie/index.md) object to a [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md) object. |
