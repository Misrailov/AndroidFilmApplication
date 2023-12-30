package com.example.filmapplication.fake.network

import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.model.film.FilmContainer
import com.example.filmapplication.model.film.FilmContainerSingular
import com.example.filmapplication.model.film.MultipleFilmsContainer
import com.example.filmapplication.network.movie.FilmApiService

class FakeFilmApiService : FilmApiService {
    override suspend fun getFilms(list: String, page: Int, startYear: Int): FilmContainer {
        return FilmContainer(
            1,
            "",
            FakeDataSource.fakeApiFilms.count(),
            FakeDataSource.fakeApiFilms)


    }

    override suspend fun getFilmById(id: String): FilmContainerSingular {
        return FilmContainerSingular(FakeDataSource.fakeApiFilms[0])
    }

    override suspend fun getFilmListByids(idsList: String): MultipleFilmsContainer {

        return MultipleFilmsContainer(FakeDataSource.fakeApiFilms.count(), FakeDataSource.fakeApiFilms)
    }
}
