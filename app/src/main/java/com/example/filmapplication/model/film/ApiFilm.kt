package com.example.filmapplication.model.film;

data class Film(
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