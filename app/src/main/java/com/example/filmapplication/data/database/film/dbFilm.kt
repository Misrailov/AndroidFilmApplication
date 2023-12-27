package com.example.filmapplication.data.database.film

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainFilm

/**
 * Data class representing a film entity in the database.
 *
 * @param id Unique identifier for the film.
 * @param primaryImage The URL of the primary image associated with the film.
 * @param titleText The title of the film.
 * @param releaseYear The release year of the film.
 * @param releaseDate The release date of the film.
 * @param position The position of the film (if applicable).
 * @param isFavourite Flag indicating if the film is a favorite.
 */
@Entity(tableName = "Films")
data class dbFilm(
    @PrimaryKey val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String = "",
    val position: Int = 0,
    val isFavourite: Boolean = false
)

/**
 * Converts a [dbFilm] object to a [DomainFilm] object.
 *
 * @return A [DomainFilm] representation of the [dbFilm].
 */
fun dbFilm.asDomainFilm(): DomainFilm {
    return DomainFilm(
        id = this.id,
        primaryImage = this.primaryImage,
        titleText = this.titleText,
        releaseYear = this.releaseYear,
        releaseDate = this.releaseDate,
        position = this.position,
        isFavourite = this.isFavourite
    )
}

/**
 * Converts a [DomainFilm] object to a [dbFilm] object.
 *
 * @return A [dbFilm] representation of the [DomainFilm].
 */
fun DomainFilm.asDbFilm(): dbFilm {
    return dbFilm(
        id = this.id,
        primaryImage = this.primaryImage,
        titleText = this.titleText,
        releaseYear = this.releaseYear,
        releaseDate = this.releaseDate.toString(),
        position = this.position,
        isFavourite = this.isFavourite
    )
}

/**
 * Converts a list of [dbFilm] objects to a list of [DomainFilm] objects.
 *
 * @return A list of [DomainFilm] representations of the [dbFilm] objects.
 */
fun List<dbFilm>.asDomainFilm(): List<DomainFilm> {
    return this.map { it.asDomainFilm() }
}
