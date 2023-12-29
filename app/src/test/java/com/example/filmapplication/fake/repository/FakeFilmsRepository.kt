package com.example.filmapplication.fake.repository

import FilmPagingSource
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeFilmsRepository:FilmRepository {
    override suspend fun insert(item: DomainFilm) {

    }

    override suspend fun update(item: DomainFilm) {
    }

    override suspend fun delete(item: DomainFilm) {
    }

    override suspend fun refresh(query: String, page: Int) {
    }

    override fun getItem(id: String): Flow<DomainFilm> {
        return flowOf(FakeDataSource.films[0])
    }

    override fun getAllItems(query: String, page: Int): Flow<List<DomainFilm>> {
        return flowOf(FakeDataSource.films)

    }

    override fun getAllFavourites(): Flow<List<DomainFilm>> {
        val films =  (FakeDataSource.films)
        films.forEach { it.isFavourite = true }
        return flowOf(films)

    }

    override suspend fun getFilms(query: String, page: Int): List<DomainFilm> {
        return FakeDataSource.films
    }

    override suspend fun getFilmDetail(id: String): DomainFilm {
        return FakeDataSource.films[0]
    }

    override suspend fun getFilmListByids(idsList: String): List<DomainFilm> {
        return FakeDataSource.films

    }

    override fun filmPagingSource(query: String): FilmPagingSource {

        return FilmPagingSource(this,"text")
    }
}