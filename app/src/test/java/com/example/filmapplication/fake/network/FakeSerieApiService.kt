package com.example.filmapplication.fake.network

import com.example.filmapplication.model.Caption
import com.example.filmapplication.model.PrimaryImage
import com.example.filmapplication.model.ReleaseDate
import com.example.filmapplication.model.TitleText
import com.example.filmapplication.model.TitleType
import com.example.filmapplication.model.YearRange
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.model.serie.ApiSerie
import com.example.filmapplication.model.serie.SerieContainer
import com.example.filmapplication.model.serie.SerieContainerSingular
import com.example.filmapplication.network.serie.SerieApiService

class FakeSerieApiService:SerieApiService {
    override suspend fun getSeries(list: String, page: Int, startYear: Int): SerieContainer {
        return SerieContainer(1,"",FakeDataSource.fakeApiFilms.count(),FakeDataSource.fakeApiSeries)
    }

    override suspend fun getSerieById(id: String): SerieContainerSingular {
        return SerieContainerSingular(FakeDataSource.fakeApiSeries[0])
    }
}