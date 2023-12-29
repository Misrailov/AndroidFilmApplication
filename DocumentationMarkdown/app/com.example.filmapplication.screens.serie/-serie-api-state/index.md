//[app](../../../index.md)/[com.example.filmapplication.screens.serie](../index.md)/[SerieApiState](index.md)

# SerieApiState

interface [SerieApiState](index.md)

Sealed interface representing the possible states of a TV series API request.

#### Inheritors

| |
|---|
| [Success](-success/index.md) |
| [Error](-error/index.md) |
| [Loading](-loading/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>object [Error](-error/index.md) : [SerieApiState](index.md)<br>Represents an error state for a TV series API request. |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [SerieApiState](index.md)<br>Represents a loading state for a TV series API request. |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [SerieApiState](index.md)<br>Represents a successful TV series API request state. |
