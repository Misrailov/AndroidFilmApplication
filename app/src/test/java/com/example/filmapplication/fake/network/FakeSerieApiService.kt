package com.example.filmapplication.fake.network

import Caption
import PrimaryImage
import ReleaseDate
import TitleText
import TitleType
import YearRange
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.model.serie.ApiSerie
import com.example.filmapplication.model.serie.SerieContainer
import com.example.filmapplication.network.serie.SerieApiService

class FakeSerieApiService:SerieApiService {
    override suspend fun getSeries(list: String, page: Int, startYear: Int): SerieContainer {
        return SerieContainer(1,"",FakeDataSource.fakeApiFilms.count(),FakeDataSource.fakeApiSeries)
    }

    override suspend fun getSerieById(id: String): ApiSerie {
        return FakeDataSource.fakeApiSeries[0]
    }
}