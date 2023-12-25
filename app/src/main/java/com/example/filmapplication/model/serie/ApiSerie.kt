package com.example.filmapplication.model.serie

import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.model.film.ApiFilm
import java.time.LocalDate

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

data class PrimaryImage(
        val id: String,
        val width: Int,
        val height: Int,
        val url: String,
        val caption: Caption
)

data class Caption(
        val plainText: String,
        val __typename: String
)

data class TitleType(
        val text: String,
        val id: String,
        val isSeries: Boolean,
        val isEpisode: Boolean,
        val __typename: String
)

data class TitleText(
        val text: String,
        val __typename: String
)

data class YearRange(
        val year: Int,
        val endYear: Int?,
        val __typename: String
)

data class ReleaseDate(
        val day: Int,
        val month: Int,
        val year: Int,
        val __typename: String
)

fun ApiSerie.asDomainSerie(): DomainSerie {
        return DomainSerie(
                id = this._id, primaryImage = this.primaryImage.url,
                titleText = this.titleText.text, releaseYear = releaseYear.year,
                releaseDate = LocalDate.of(this.releaseDate!!.year, this.releaseDate.month, releaseDate.day)
                        .toString()
        )
}
