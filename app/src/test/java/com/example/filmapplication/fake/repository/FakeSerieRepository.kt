package com.example.filmapplication.fake.repository

import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.fake.FakeDataSource
import com.example.filmapplication.repository.SerieRepository
import com.example.filmapplication.screens.serie.SeriePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSerieRepository:SerieRepository {
    override suspend fun insert(item: DomainSerie) {
    }

    override suspend fun update(item: DomainSerie) {
    }

    override suspend fun delete(item: DomainSerie) {
    }

    override suspend fun refresh(query: String, page: Int) {
    }

    override fun getItem(id: String): Flow<DomainSerie> {
        return flowOf(FakeDataSource.series[0])
    }

    override fun getAllItems(query: String, page: Int): Flow<List<DomainSerie>> {
        return flowOf(FakeDataSource.series)
    }

    override fun getAllFavourites(): Flow<List<DomainSerie>> {
        val series = FakeDataSource.series
        series.forEach { it.isFavourite = true }

        return flowOf(series)
    }

    override suspend fun getSeries(query: String, page: Int): List<DomainSerie> {
        return FakeDataSource.series
    }

    override suspend fun getSerieById(id: String): DomainSerie {
        return FakeDataSource.series[0]
    }

    override fun seriePagingSource(query: String): SeriePagingSource {
        return SeriePagingSource(this,"fake")
    }
}