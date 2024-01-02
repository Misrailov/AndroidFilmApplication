package com.example.filmapplication.dao


import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.domain.DomainSerie



object FakeDataSource {


    var actors = listOf(
        DomainActor("fakeID1", "John Doe", "1987", "2021", "Actor", "fakemovieList"),
        DomainActor("fakeID2", "Jane Smith", "1990", "2019", "Actress", "anotherFakeMovieList"),
        DomainActor(
            "fakeID3",
            "Michael Johnson",
            "1985",
            "2020",
            "Actor",
            "yetAnotherFakeMovieList"
        ),
        DomainActor("fakeID4", "Emily Davis", "1993", "2018", "Actress", "fakeMovieList123"),
        DomainActor("fakeID5", "William Brown", "1980", "2022", "Actor", "fakeMoviesRUs"),
        DomainActor("fakeID6", "Olivia Wilson", "1989", "2017", "Actress", "movieFakes"),
        DomainActor("fakeID7", "Daniel Lee", "1992", "2020", "Actor", "fakeMovieDB"),
        DomainActor("fakeID8", "Sophia Kim", "1988", "2019", "Actress", "fakemovieListXYZ"),
        DomainActor("fakeID9", "Alexander Miller", "1983", "2021", "Actor", "movies4RealFake"),
        DomainActor("fakeID10", "Ella Anderson", "1991", "2018", "Actress", "fakeMovieTime")
    )
//

    val films = listOf(
        DomainFilm(
            "fakeMovieID1",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Donkey Kong",
            1989,
            "1989-12-1",
            1, true
        ),
        DomainFilm(
            "fakeMovieID2",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "The Lost Treasure",
            2005,
            "2005-07-15",
            2, true
        ),
        DomainFilm(
            "fakeMovieID3",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Inception",
            2010,
            "2010-07-16",
            3, true
        ),
        DomainFilm(
            "fakeMovieID4",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Jurassic Park",
            1993,
            "1993-06-11",
            4, true
        ),
        DomainFilm(
            "fakeMovieID6",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "The Dark Knight",
            2008,
            "2008-07-18",
            6, true
        ),
        DomainFilm(
            "fakeMovieID5",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Avatar",
            2009,
            "2009-12-18",
            5, true
        ),
        DomainFilm(
            "fakeMovieID8",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "The Shawshank Redemption",
            1994,
            "1994-09-23",
            8, true
        ),
        DomainFilm(
            "fakeMovieID9",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Forrest Gump",
            1994,
            "1994-07-06",
            9, true
        ),
        DomainFilm(
            "fakeMovieID10",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "The Matrix",
            1999,
            "1999-03-31",
            10, true
        ),
        DomainFilm(
            "fakeMovieID7",
            "https://www.nme.com/wp-content/uploads/2023/07/dwayne-johnson-the-rock-actors-strike.jpg",
            "Pulp Fiction",
            1994,
            "1994-10-14",
            7, true
        )
    )


    val series = listOf(
        DomainSerie(
            "fakeSerieID1",
            "hthttps://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Game of Thrones",
            1989,
            "1989-12-1",
            1, true
        ),
        DomainSerie(
            "fakeSerieID2",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Breaking Bad",
            2008,
            "2008-01-20",
            2, true
        ),
        DomainSerie(
            "fakeSerieID3",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Stranger Things",
            2016,
            "2016-07-15",
            3, true
        ),
        DomainSerie(
            "fakeSerieID4",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "The Crown",
            2016,
            "2016-11-04",
            4, true
        ),
        DomainSerie(
            "fakeSerieID5",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Friends",
            1994,
            "1994-09-22",
            5, true
        ),
        DomainSerie(
            "fakeSerieID6",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "The Office",
            2005,
            "2005-03-24",
            6, true
        ),
        DomainSerie(
            "fakeSerieID7",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Sherlock",
            2010,
            "2010-07-25",
            7, true
        ),
        DomainSerie(
            "fakeSerieID8",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Westworld",
            2016,
            "2016-10-02",
            8, true
        ),
        DomainSerie(
            "fakeSerieID9",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "Black Mirror",
            2011,
            "2011-12-04",
            9, true
        ),
        DomainSerie(
            "fakeSerieID10",
            "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            "The Mandalorian",
            2019,
            "2019-11-12",
            10, true
        )
    )




}