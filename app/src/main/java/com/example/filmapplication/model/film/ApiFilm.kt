package com.example.filmapplication.model.film;

import PrimaryImage
import ReleaseDate
import TitleText
import TitleType
import YearRange
import com.example.filmapplication.domain.DomainFilm
import java.time.LocalDate

/**
 * Represents a film retrieved from an API.
 *
 * @property _id The unique identifier for the film.
 * @property id The ID of the film.
 * @property primaryImage The URL of the primary image associated with the film.
 * @property titleType The type of the film's title.
 * @property titleText The text of the film's title.
 * @property originalTitleText The original text of the film's title.
 * @property releaseYear The release year of the film.
 * @property releaseDate The release date of the film.
 * @property position The position of the film.
 */
data class ApiFilm(
    val _id: String,
    val id: String,
    val primaryImage: PrimaryImage,
    val titleType: TitleType,
    val titleText: TitleText,
    val originalTitleText: TitleText,
    val releaseYear: YearRange,
    val releaseDate: ReleaseDate?,
    val position: Int?

)

/**
 * Converts an [ApiFilm] object to a [DomainFilm] object.
 *
 * @return A [DomainFilm] object.
 */
fun ApiFilm.asDomainFilm(): DomainFilm {
    return DomainFilm(
        id = this._id, primaryImage = this.primaryImage.url,
        titleText = this.titleText.text, releaseYear = releaseYear.year,
        releaseDate = LocalDate.of((if(this.releaseDate!=null) this.releaseDate.year else 0)!!, if(this.releaseDate?.month !=null) this.releaseDate?.month else 0,
            (if(this.releaseDate?.month !=null) releaseDate.day else 0)!!
        )!!
            .toString()
    )
}