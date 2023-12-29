//[app](../../../index.md)/[com.example.filmapplication.data](../index.md)/[DefaultAppContainer](index.md)

# DefaultAppContainer

class [DefaultAppContainer](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](../-app-container/index.md)

Default implementation of the [AppContainer](../-app-container/index.md) interface, providing access to repositories for actors, films, and series.

#### Parameters

androidJvm

| | |
|---|---|
| context | The application context. |

## Constructors

| | |
|---|---|
| [DefaultAppContainer](-default-app-container.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [actorRepository](actor-repository.md) | [androidJvm]<br>open override val [actorRepository](actor-repository.md): [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md) |
| [filmRepository](film-repository.md) | [androidJvm]<br>open override val [filmRepository](film-repository.md): [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md) |
| [serieRepository](serie-repository.md) | [androidJvm]<br>open override val [serieRepository](serie-repository.md): [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md) |
