package com.example.filmapplication.model.serie

import com.example.filmapplication.model.PrimaryImage
import com.example.filmapplication.model.ReleaseDate
import com.example.filmapplication.model.TitleText
import com.example.filmapplication.model.TitleType
import com.example.filmapplication.model.YearRange
import com.example.filmapplication.domain.DomainSerie
import java.time.LocalDate
/**
 * Represents a series retrieved from an API.
 *
 * @property _id The unique identifier for the series.
 * @property id The ID of the series.
 * @property primaryImage The URL of the primary image associated with the series.
 * @property titleType The type of the series title.
 * @property titleText The text of the series title.
 * @property originalTitleText The original text of the series title.
 * @property releaseYear The release year of the series.
 * @property releaseDate The release date of the series.
 */
data class ApiSerie(
        val _id: String,
        val id: String,
        val primaryImage: PrimaryImage,
        val titleType: TitleType,
        val titleText: TitleText,
        val originalTitleText: TitleText,
        val releaseYear: YearRange,
        val releaseDate: ReleaseDate
)
/**
 * Converts an [ApiSerie] object to a [DomainSerie] object.
 *
 * @return A [DomainSerie] object.
 */
fun ApiSerie.asDomainSerie(): DomainSerie {
        return DomainSerie(
                id = this.id, primaryImage = this.primaryImage.url,
                titleText = this.titleText.text, releaseYear = releaseYear.year,
                releaseDate = LocalDate.of(this.releaseDate.year!!, this.releaseDate.month!!, releaseDate.day!!)
                        .toString()
        )
}
