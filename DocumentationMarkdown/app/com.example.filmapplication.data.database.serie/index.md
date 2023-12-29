//[app](../../index.md)/[com.example.filmapplication.data.database.serie](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [dbSerie](db-serie/index.md) | [androidJvm]<br>data class [dbSerie](db-serie/index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val primaryImage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val titleText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val releaseYear: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val releaseDate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val isFavourite: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Represents a data class for a series entity in the Room database. |
| [SerieDao](-serie-dao/index.md) | [androidJvm]<br>interface [SerieDao](-serie-dao/index.md)<br>Data Access Object (DAO) interface for interacting with the series database table. |

## Functions

| Name | Summary |
|---|---|
| [asDbSerie](as-db-serie.md) | [androidJvm]<br>fun [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md).[asDbSerie](as-db-serie.md)(): [dbSerie](db-serie/index.md)<br>Converts a [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md) object into a [dbSerie](db-serie/index.md) object. |
| [asDomainSerie](as-domain-serie.md) | [androidJvm]<br>fun [dbSerie](db-serie/index.md).[asDomainSerie](as-domain-serie.md)(): [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md)<br>Converts a [dbSerie](db-serie/index.md) object into a [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md) object.<br>[androidJvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbSerie](db-serie/index.md)&gt;.[asDomainSerie](as-domain-serie.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md)&gt;<br>Converts a list of [dbSerie](db-serie/index.md) objects into a list of [DomainSerie](../com.example.filmapplication.domain/-domain-serie/index.md) objects. |
