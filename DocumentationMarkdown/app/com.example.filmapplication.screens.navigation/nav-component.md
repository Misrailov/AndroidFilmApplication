//[app](../../index.md)/[com.example.filmapplication.screens.navigation](index.md)/[navComponent](nav-component.md)

# navComponent

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [navComponent](nav-component.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html), navigationType: [FilmApplicationNavigationType](../com.example.filmapplication.screens.utils/-film-application-navigation-type/index.md), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onActorClick: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A composable function that defines the navigation component for the Film Application.

#### Parameters

androidJvm

| | |
|---|---|
| navController | The [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html) responsible for handling navigation within the app. |
| navigationType | The type of navigation within the Film Application. |
| modifier | Modifier for styling and positioning the navigation component. |
| onActorClick | A callback function to handle actor item clicks. |
