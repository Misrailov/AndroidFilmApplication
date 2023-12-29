//[app](../../../index.md)/[com.example.filmapplication.screens.home](../index.md)/[HomeApiState](index.md)

# HomeApiState

interface [HomeApiState](index.md)

Sealed interface representing the API states for the Home screen.

#### Inheritors

| |
|---|
| [Success](-success/index.md) |
| [Error](-error/index.md) |
| [Loading](-loading/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>object [Error](-error/index.md) : [HomeApiState](index.md)<br>Represents an error in the API response. |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [HomeApiState](index.md)<br>Represents the loading state while waiting for the API response. |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [HomeApiState](index.md)<br>Represents a successful API response. |
