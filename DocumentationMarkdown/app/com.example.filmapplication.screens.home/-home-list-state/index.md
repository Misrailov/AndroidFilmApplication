//[app](../../../index.md)/[com.example.filmapplication.screens.home](../index.md)/[HomeListState](index.md)

# HomeListState

data class [HomeListState](index.md)(val films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt; = listOf(), val series: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt; = listOf(), val actors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf())

Data class representing the state of the Home screen lists.

#### Parameters

androidJvm

| | |
|---|---|
| films | List of favorite films. |
| series | List of favorite series. |
| actors | List of favorite actors. |

## Constructors

| | |
|---|---|
| [HomeListState](-home-list-state.md) | [androidJvm]<br>constructor(films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt; = listOf(), series: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt; = listOf(), actors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; = listOf()) |

## Properties

| Name | Summary |
|---|---|
| [actors](actors.md) | [androidJvm]<br>val [actors](actors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)&gt; |
| [films](films.md) | [androidJvm]<br>val [films](films.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt; |
| [series](series.md) | [androidJvm]<br>val [series](series.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt; |
