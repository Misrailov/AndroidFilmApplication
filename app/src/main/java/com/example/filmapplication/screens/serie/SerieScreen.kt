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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.R

/**
 * Composable function for displaying a screen that lists TV series.
 *
 * @param serieViewModel The view model for managing TV series data.
 */
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

    fun addSerieFav(serie:DomainSerie,isFavourite:Boolean){
        serieViewModel.addSerieToFavourites(serie,isFavourite)
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
                            Text(text = stringResource(id = R.string.Most_Popular_Series), Modifier.padding(start = dimensionResource(id = R.dimen.standard_padding), end = dimensionResource(id = R.dimen.standard_padding)))

                            SerieList(seriesPaged = mostPopSeries, addSerieToFav = ::addSerieFav, favouriteSeries =  favouriteSeries)
                        }
                    }
                    item {
                        Column {
                            Text(text = stringResource(id = R.string.Top_Rated_Series), Modifier.padding(start = dimensionResource(id = R.dimen.standard_padding), end = dimensionResource(id = R.dimen.standard_padding)))
                            SerieList(seriesPaged = topRatedSeries, addSerieToFav = ::addSerieFav, favouriteSeries = favouriteSeries)
                        }
                    }

                }
            }
        }

    }
}
/**
 * Composable function for displaying a list of TV series.
 *
 * @param serieList List of TV series data.
 * @param seriesPaged LazyPagingItems for paged TV series data.
 * @param addSerieToFav Function to add a TV series to favorites.
 * @param favouriteSeries List of favorite TV series.
 */
@Composable
fun SerieList(
    serieList:List<DomainSerie>? = listOf<DomainSerie>(),
    seriesPaged: LazyPagingItems<DomainSerie>?=null,
    addSerieToFav:(serie: DomainSerie,isFavourite:Boolean)->Unit,
    favouriteSeries: List<DomainSerie>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = dimensionResource(id = R.dimen.min_height))
            .padding(start = dimensionResource(id = R.dimen.standard_padding))
    ) {
        if(serieList.isNullOrEmpty() && seriesPaged?.itemCount == 0){
            item {
                Text(stringResource(id = R.string.No_Series))
            }
        }
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
                SerieComposable(
                    serie = serie,
                    addSerieToFav = addSerieToFav,
                    isFavourite = isFavourite

                )
            } }
        }


    }
}

/**
 * Composable function for displaying a single TV series item.
 *
 * @param serie TV series data.
 * @param addSerieToFav Function to add a TV series to favorites.
 * @param isFavourite Flag indicating if the TV series is in favorites.
 */
@Composable
fun SerieComposable(
    serie: DomainSerie,
    addSerieToFav:(serie: DomainSerie,isFavourite:Boolean)->Unit,
    isFavourite: Boolean

) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding),
                vertical = dimensionResource(id = R.dimen.medium_padding)
            )
            .fillMaxWidth()
            .defaultMinSize(dimensionResource(id = R.dimen.standard_min_size)),

        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.standard_elevation)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = serie.primaryImage),
                contentDescription = stringResource(id = R.string.Photo_Of) + " ${serie.titleText}",
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.standard_width))
                    .height(dimensionResource(id = R.dimen.img_card_size))
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.medium_padding))
            ) {
                Text(
                    text = serie.titleText,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.medium_padding))
                )
                Text(
                    text = stringResource(id = R.string.Released_in) + " ${serie.releaseYear}",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.small_padding))
                )
                Button(onClick = { addSerieToFav(serie,isFavourite)}) {
                    Text(text = if (!isFavourite) stringResource(id = R.string.Add_Favourites) else stringResource(
                        id = R.string.Remove_Favourites
                    ))
                }
            }
        }
    }
}


