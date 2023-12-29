//[app](../../../index.md)/[com.example.filmapplication.screens.actor](../index.md)/[ActorApiState](index.md)

# ActorApiState

interface [ActorApiState](index.md)

Sealed interface defining possible states for the API calls related to actors.

#### Inheritors

| |
|---|
| [Success](-success/index.md) |
| [Error](-error/index.md) |
| [Loading](-loading/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>object [Error](-error/index.md) : [ActorApiState](index.md)<br>Indicates an error occurred during the API call. |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [ActorApiState](index.md)<br>Indicates that the API call is in progress. |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [ActorApiState](index.md)<br>Indicates a successful API call. |
