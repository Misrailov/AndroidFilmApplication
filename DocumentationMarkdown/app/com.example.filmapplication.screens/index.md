//[app](../../index.md)/[com.example.filmapplication.screens](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Destinations](-destinations/index.md) | [androidJvm]<br>enum [Destinations](-destinations/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Destinations](-destinations/index.md)&gt; <br>Enum class representing various destinations in the film application. |

## Functions

| Name | Summary |
|---|---|
| [ErrorScreen](-error-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ErrorScreen](-error-screen.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>Composable function for displaying an error screen with an error image and message. |
| [FilmApp](-film-app.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [FilmApp](-film-app.md)(navigationType: [FilmApplicationNavigationType](../com.example.filmapplication.screens.utils/-film-application-navigation-type/index.md), navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html) = rememberNavController())<br>Composable function for the main film application. |
| [LoadingScreen](-loading-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LoadingScreen](-loading-screen.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>Composable function for displaying a loading screen with a loading image. |
