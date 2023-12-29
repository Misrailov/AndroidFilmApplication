//[app](../../../index.md)/[com.example.filmapplication.screens.actor.ActorDetails](../index.md)/[ActorDetailViewUiState](index.md)

# ActorDetailViewUiState

interface [ActorDetailViewUiState](index.md)

Represents the possible UI states for the Actor Detail screen.

#### Inheritors

| |
|---|
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>object [Error](-error/index.md) : [ActorDetailViewUiState](index.md)<br>Error state: Indicates that an error occurred while fetching data. |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [ActorDetailViewUiState](index.md)<br>Loading state: Indicates that data is being fetched. |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(val films: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;, val actor: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)) : [ActorDetailViewUiState](index.md)<br>Success state: Indicates that data has been successfully loaded. |
