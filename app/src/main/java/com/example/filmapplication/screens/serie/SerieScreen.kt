package com.example.filmapplication.screens.serie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.primaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SerieScreen(
    serieViewModel: SerieViewModel = viewModel(
        factory = SerieViewModel.Factory
    )
) {
    var mostPopSeries = serieViewModel.seriePager.collectAsLazyPagingItems()
    var topRatedSeries = serieViewModel.serieTopRatedPager.collectAsLazyPagingItems()
    val serieListState by serieViewModel.uiListSerieState.collectAsState()
    val serieApiState = serieViewModel.serieApiState
    var favouriteSeries = listOf<DomainSerie>()

    fun addSerieFav(serie:DomainSerie){
        serieViewModel.addSerieToFavourites(serie)
    }

    when (serieApiState) {
        is SerieApiState.Error -> ErrorScreen()
        is SerieApiState.Loading -> LoadingScreen()
        is SerieApiState.Success -> {
            favouriteSeries = serieListState.favouriteSeries
            Scaffold { padding ->
                Spacer(modifier = Modifier.padding(padding))
                LazyRow {
                    item {
                        Column {
                            Text(text = "Most popular series")

                            SerieList(seriesPaged = mostPopSeries, addSerieToFav = ::addSerieFav, favouriteSeries =  favouriteSeries)
                        }
                    }
                    item {
                        Column {
                            Text(text = "Top rated series")
                            SerieList(seriesPaged = topRatedSeries, addSerieToFav = ::addSerieFav, favouriteSeries = favouriteSeries)
                        }
                    }

                }
            }
        }

    }
}

@Composable
fun SerieList(
    serieList:List<DomainSerie>? = listOf<DomainSerie>(),
    seriesPaged: LazyPagingItems<DomainSerie>?=null,
    addSerieToFav:(serie: DomainSerie)->Unit,
    favouriteSeries: List<DomainSerie>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    ) {
        if(seriesPaged !=null){
        itemsIndexed(seriesPaged) { _, serie ->
            val isFavourite =
                favouriteSeries.filter { x -> x.id == serie!!.id && x.isFavourite }.isNotEmpty()
            serie?.let {
                SerieComposable(
                    serie = serie,
                    addSerieToFav = addSerieToFav,
                    isFavourite = isFavourite
                )
            }
        }

        }else{
            serieList?.forEach { serie ->item {
                val isFavourite =
                    favouriteSeries.filter { x -> x.id == serie.id && x.isFavourite }.isNotEmpty()
                serie.let {
                    SerieComposable(
                        serie = serie,
                        addSerieToFav = addSerieToFav,
                        isFavourite = isFavourite
                    )
                }
            } }
        }


    }
}


@Composable
fun SerieComposable(
    serie: DomainSerie,
    addSerieToFav:(serie: DomainSerie)->Unit,
    isFavourite: Boolean
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .defaultMinSize(300.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = serie.primaryImage),
                contentDescription = "Photo of ${serie.titleText}",
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = serie.titleText,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Text(
                    text = "Released in ${serie.releaseYear}",
                    color = primaryColor,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
                Button(onClick = { addSerieToFav(serie)}) {
                    Text(text = if (!isFavourite) "Add to Favourites" else "Remove From Favourites")
                }
            }
        }
    }
}