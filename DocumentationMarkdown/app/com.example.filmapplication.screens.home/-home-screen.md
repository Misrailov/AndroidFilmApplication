//[app](../../index.md)/[com.example.filmapplication.screens.home](index.md)/[HomeScreen](-home-screen.md)

# HomeScreen

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [HomeScreen](-home-screen.md)(homeViewModel: [HomeViewModel](-home-view-model/index.md) = viewModel(factory = HomeViewModel.Factory), goToActor: (id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable function that displays the home screen with lists of favorite movies, series, and actors.

#### Parameters

androidJvm

| | |
|---|---|
| homeViewModel | The ViewModel responsible for managing the data and state of the home screen. |
| performClick | A lambda function to handle item clicks when navigating to details screens. |
