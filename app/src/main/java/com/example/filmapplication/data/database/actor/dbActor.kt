package com.example.filmapplication.data.database.actor

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainActor

/**
 * Data class representing an actor entity in the database.
 *
 * @param nconst Unique identifier for the actor.
 * @param primaryName The primary name of the actor.
 * @param birthYear The birth year of the actor.
 * @param deathYear The death year of the actor.
 * @param primaryProfession The primary profession of the actor.
 * @param knownForTitles Titles the actor is known for.
 * @param isFavourite Flag indicating if the actor is a favorite.
 */
@Entity(tableName = "Actors")
data class dbActor(
    @PrimaryKey val nconst: String = "",
    val primaryName: String = "",
    val birthYear: String = "0",
    val deathYear: String = "0",
    val primaryProfession: String = "",
    val knownForTitles: String = "",
    val isFavourite: Boolean = false
)

private val dbActor.domainActor: DomainActor
    get() = DomainActor(
        nconst = this.nconst,
        primaryName = this.primaryName,
        birthYear = this.birthYear,
        deathYear = this.deathYear,
        primaryProfession = this.primaryProfession,
        knownForTitles = this.knownForTitles,
        isFavourite = this.isFavourite
    )

/**
 * Converts a [dbActor] object to a [DomainActor] object.
 *
 * @return A [DomainActor] representation of the [dbActor].
 */
fun dbActor.asDomainActor(): DomainActor {
    Log.e("dbActor", this.toString())
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

/**
 * Converts a [DomainActor] object to a [dbActor] object.
 *
 * @return A [dbActor] representation of the [DomainActor].
 */
fun DomainActor.asDbActor(): dbActor {
    return dbActor(
        nconst = this.nconst,
        primaryName = primaryName,
        birthYear = this.birthYear,
        deathYear = this.deathYear,
        primaryProfession = this.primaryProfession,
        knownForTitles = this.knownForTitles,
        isFavourite = this.isFavourite
    )
}

/**
 * Converts a list of [dbActor] objects to a list of [DomainActor] objects.
 *
 * @return A list of [DomainActor] representations of the [dbActor] objects.
 */
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
