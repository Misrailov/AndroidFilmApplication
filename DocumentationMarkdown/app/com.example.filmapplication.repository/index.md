//[app](../../index.md)/[com.example.filmapplication.repository](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ActorRepository](-actor-repository/index.md) | [androidJvm]<br>interface [ActorRepository](-actor-repository/index.md)<br>Repository interface for managing actor data. |
| [CachingActorRepository](-caching-actor-repository/index.md) | [androidJvm]<br>class [CachingActorRepository](-caching-actor-repository/index.md)(actorDao: [ActorDao](../com.example.filmapplication.data.database.actor/-actor-dao/index.md), actorApiService: [ActorApiService](../com.example.filmapplication.network.actor/-actor-api-service/index.md)) : [ActorRepository](-actor-repository/index.md)<br>Implementation of [ActorRepository](-actor-repository/index.md) that caches actor data. |
| [CachingFilmRepository](-caching-film-repository/index.md) | [androidJvm]<br>class [CachingFilmRepository](-caching-film-repository/index.md)(filmDao: [FilmDao](../com.example.filmapplication.data.database.film/-film-dao/index.md), filmApiService: [FilmApiService](../com.example.filmapplication.network.movie/-film-api-service/index.md)) : [FilmRepository](-film-repository/index.md)<br>Implementation of [FilmRepository](-film-repository/index.md) that caches film data. |
| [CachingSerieRepository](-caching-serie-repository/index.md) | [androidJvm]<br>class [CachingSerieRepository](-caching-serie-repository/index.md)(serieDao: [SerieDao](../com.example.filmapplication.data.database.serie/-serie-dao/index.md), serieApiService: [SerieApiService](../com.example.filmapplication.network.serie/-serie-api-service/index.md)) : [SerieRepository](-serie-repository/index.md)<br>Implementation of [SerieRepository](-serie-repository/index.md) that caches series data. |
| [FilmRepository](-film-repository/index.md) | [androidJvm]<br>interface [FilmRepository](-film-repository/index.md)<br>Repository interface for managing film data. |
| [SerieRepository](-serie-repository/index.md) | [androidJvm]<br>interface [SerieRepository](-serie-repository/index.md)<br>Repository interface for managing series data. |
