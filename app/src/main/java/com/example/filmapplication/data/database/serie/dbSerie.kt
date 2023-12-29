package com.example.filmapplication.data.database.serie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainSerie

@Entity(tableName = "Series")
/**
 * Represents a data class for a series entity in the Room database.
 *
 * @param id The unique identifier for the series.
 * @param primaryImage The URL of the primary image for the series.
 * @param titleText The title text of the series.
 * @param releaseYear The release year of the series.
 * @param releaseDate The release date of the series.
 * @param position The position of the series.
 * @param isFavourite Indicates whether the series is marked as a favorite.
 */
data class dbSerie(
    @PrimaryKey
    val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String = "",
    val position: Int = 0,
    val isFavourite: Boolean = false
)
/**
 * Converts a [dbSerie] object into a [DomainSerie] object.
 *
 * @return The corresponding [DomainSerie] object.
 */
fun dbSerie.asDomainSerie(): DomainSerie {
    return DomainSerie(
        id = this.id, primaryImage = this.primaryImage,
        titleText = this.titleText, releaseYear = this.releaseYear, releaseDate = this.releaseDate,
        position = this.position,
        isFavourite = this.isFavourite
    )
}
/**
 * Converts a [DomainSerie] object into a [dbSerie] object.
 *
 * @return The corresponding [dbSerie] object.
 */
fun DomainSerie.asDbSerie(): dbSerie {
    return dbSerie(
        id = this.id, primaryImage = this.primaryImage,
        titleText = this.titleText, releaseYear = this.releaseYear, releaseDate = this.releaseDate,
        position = this.position, isFavourite = this.isFavourite
    )
}
/**
 * Converts a list of [dbSerie] objects into a list of [DomainSerie] objects.
 *
 * @return The corresponding list of [DomainSerie] objects.
 */
fun List<dbSerie>.asDomainSerie(): List<DomainSerie> {
    return this.map { it.asDomainSerie() }
}