package com.example.filmapplication.data.database.serie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainSerie

@Entity(tableName = "Series")

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

fun dbSerie.asDomainSerie(): DomainSerie {
    return DomainSerie(
        id = this.id, primaryImage = this.primaryImage,
        titleText = this.titleText, releaseYear = this.releaseYear, releaseDate = this.releaseDate,
        position = this.position,
        isFavourite = this.isFavourite
    )
}

fun DomainSerie.asDbSerie(): dbSerie {
    return dbSerie(
        id = this.id, primaryImage = this.primaryImage,
        titleText = this.titleText, releaseYear = this.releaseYear, releaseDate = this.releaseDate,
        position = this.position, isFavourite = this.isFavourite
    )
}

fun List<dbSerie>.asDomainSerie(): List<DomainSerie> {
    return this.map { it.asDomainSerie() }
}