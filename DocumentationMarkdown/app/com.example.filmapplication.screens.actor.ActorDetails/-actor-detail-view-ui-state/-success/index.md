//[app](../../../../index.md)/[com.example.filmapplication.screens.actor.ActorDetails](../../index.md)/[ActorDetailViewUiState](../index.md)/[Success](index.md)

# Success

[androidJvm]\
data class [Success](index.md)(val films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../../com.example.filmapplication.domain/-domain-film/index.md)&gt;, val actor: [DomainActor](../../../com.example.filmapplication.domain/-domain-actor/index.md)) : [ActorDetailViewUiState](../index.md)

Success state: Indicates that data has been successfully loaded.

## Constructors

| | |
|---|---|
| [Success](-success.md) | [androidJvm]<br>constructor(films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../../com.example.filmapplication.domain/-domain-film/index.md)&gt;, actor: [DomainActor](../../../com.example.filmapplication.domain/-domain-actor/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [actor](actor.md) | [androidJvm]<br>val [actor](actor.md): [DomainActor](../../../com.example.filmapplication.domain/-domain-actor/index.md)<br>The detailed information about the actor. |
| [films](films.md) | [androidJvm]<br>val [films](films.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>The list of films associated with the actor. |
