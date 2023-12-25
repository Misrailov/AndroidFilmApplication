package com.example.filmapplication.data.database.actor

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainActor


@Entity(tableName = "Actors")
data class dbActor(
    @PrimaryKey
    val nconst: String = "",
    val primaryName: String = "",
    val birthYear: Int = 0,
    val deathYear: Int = 0,
    val primaryProfession: String = "",
    val knownForTitles: String = "",
    val isFavourite: Boolean = false
)


fun dbActor.asDomainActor(): DomainActor {
    return DomainActor(
        nconst = this.nconst,
        primaryName = this.primaryName,
        birthYear = this.birthYear,
        deathYear = this.deathYear,
        primaryProfession = this.primaryProfession,
        knownForTitles = this.knownForTitles,
        isFavourite = this.isFavourite
    )
}

fun DomainActor.asDbActor(): dbActor {
    return dbActor(
        nconst = this.nconst, primaryName = primaryName,
        birthYear = this.birthYear, deathYear = this.deathYear,
        primaryProfession = this.primaryProfession, knownForTitles = this.knownForTitles,
        isFavourite = this.isFavourite
    )
}

fun List<dbActor>.asDomainActors(): List<DomainActor> {
    return this.map {
        DomainActor(
            nconst = it.nconst,
            primaryName = it.primaryName,
            birthYear = it.birthYear,
            deathYear = it.deathYear,
            primaryProfession = it.primaryProfession,
            knownForTitles = it.knownForTitles,
            isFavourite = it.isFavourite
        )
    }
}