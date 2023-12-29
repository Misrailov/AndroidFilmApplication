//[app](../../../index.md)/[com.example.filmapplication.network](../index.md)/[NetworkConnectionInterceptor](index.md)

# NetworkConnectionInterceptor

[androidJvm]\
class [NetworkConnectionInterceptor](index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : Interceptor

Interceptor for checking network connectivity before making network requests.

## Constructors

| | |
|---|---|
| [NetworkConnectionInterceptor](-network-connection-interceptor.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)<br>The [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) used to check network connectivity. |

## Functions

| Name | Summary |
|---|---|
| [intercept](intercept.md) | [androidJvm]<br>open override fun [intercept](intercept.md)(chain: Interceptor.Chain): Response<br>Intercepts the network request and checks for network connectivity. |
| [isConnected](is-connected.md) | [androidJvm]<br>fun [isConnected](is-connected.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the device is connected to a network. |
