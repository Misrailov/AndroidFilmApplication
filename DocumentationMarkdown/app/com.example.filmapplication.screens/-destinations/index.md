//[app](../../../index.md)/[com.example.filmapplication.screens](../index.md)/[Destinations](index.md)

# Destinations

[androidJvm]\
enum [Destinations](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Destinations](index.md)&gt; 

Enum class representing various destinations in the film application.

## Entries

| | |
|---|---|
| [Home](-home/index.md) | [androidJvm]<br>[Home](-home/index.md) |
| [Movies](-movies/index.md) | [androidJvm]<br>[Movies](-movies/index.md) |
| [Series](-series/index.md) | [androidJvm]<br>[Series](-series/index.md) |
| [Actors](-actors/index.md) | [androidJvm]<br>[Actors](-actors/index.md) |
| [ActorsDetail](-actors-detail/index.md) | [androidJvm]<br>[ActorsDetail](-actors-detail/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [androidJvm]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Destinations](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [icon](icon.md) | [androidJvm]<br>val [icon](icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)<br>The icon associated with the destination. |
| [name](../../com.example.filmapplication.screens.utils/-film-application-navigation-type/-p-e-r-m-a-n-e-n-t_-n-a-v-i-g-a-t-i-o-n_-d-r-a-w-e-r/index.md#-372974862%2FProperties%2F-912451524) | [androidJvm]<br>val [name](../../com.example.filmapplication.screens.utils/-film-application-navigation-type/-p-e-r-m-a-n-e-n-t_-n-a-v-i-g-a-t-i-o-n_-d-r-a-w-e-r/index.md#-372974862%2FProperties%2F-912451524): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](../../com.example.filmapplication.screens.utils/-film-application-navigation-type/-p-e-r-m-a-n-e-n-t_-n-a-v-i-g-a-t-i-o-n_-d-r-a-w-e-r/index.md#-739389684%2FProperties%2F-912451524) | [androidJvm]<br>val [ordinal](../../com.example.filmapplication.screens.utils/-film-application-navigation-type/-p-e-r-m-a-n-e-n-t_-n-a-v-i-g-a-t-i-o-n_-d-r-a-w-e-r/index.md#-739389684%2FProperties%2F-912451524): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [route](route.md) | [androidJvm]<br>val [route](route.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The route associated with the destination. |

## Functions

| Name | Summary |
|---|---|
| [createRoute](create-route.md) | [androidJvm]<br>fun [createRoute](create-route.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a route with the specified ID appended to the destination's route. |
| [valueOf](value-of.md) | [androidJvm]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Destinations](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [androidJvm]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Destinations](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |
