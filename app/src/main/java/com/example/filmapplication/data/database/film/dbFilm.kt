package com.example.filmapplication.data.database.film

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.model.film.ApiFilm


@Entity(tableName = "Films")
data class dbFilm(
    @PrimaryKey
    val id:String = "",
    val primaryImage:String = "",
    val titleText:String = "",
    val releaseYear:Int =0,
    val releaseDate:String = "",
    val position:Int = 0,
    val isFavourite: Boolean = false
)
fun dbFilm.asDomainFilm():DomainFilm{
    return DomainFilm(id =this.id,primaryImage=this.primaryImage,
        titleText= this.titleText,releaseYear=this.releaseYear,
        releaseDate=this.releaseDate,position=this.position,isFavourite = this.isFavourite)
}
fun DomainFilm.asDbFilm():dbFilm{
    return dbFilm(id =this.id,primaryImage=this.primaryImage,
        titleText= this.titleText,releaseYear=this.releaseYear,
        releaseDate=this.releaseDate,position=this.position, isFavourite = this.isFavourite)
}
fun List<dbFilm>.asDomainFilm():List<DomainFilm>{
    return this.map { it.asDomainFilm() }
}