//[app](../../index.md)/[com.example.taskapp.ui.components](index.md)/[FilmNavigationRail](-film-navigation-rail.md)

# FilmNavigationRail

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FilmNavigationRail](-film-navigation-rail.md)(selectedDestination: [NavDestination](https://developer.android.com/reference/kotlin/androidx/navigation/NavDestination.html)?, onTabPressed: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)

A custom [NavigationRail](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary.html) component for navigating between different film-related destinations.

#### Parameters

androidJvm

| | |
|---|---|
| selectedDestination | The currently selected navigation destination. |
| onTabPressed | The callback to be invoked when a navigation tab is pressed. |
| modifier | Modifier for styling and positioning the [NavigationRail](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary.html). |
