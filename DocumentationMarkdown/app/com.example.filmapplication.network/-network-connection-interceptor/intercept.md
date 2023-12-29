//[app](../../../index.md)/[com.example.filmapplication.network](../index.md)/[NetworkConnectionInterceptor](index.md)/[intercept](intercept.md)

# intercept

[androidJvm]\
open override fun [intercept](intercept.md)(chain: Interceptor.Chain): Response

Intercepts the network request and checks for network connectivity.

#### Return

The Response of the network request if there is a connection; otherwise, an IOException is thrown.

#### Parameters

androidJvm

| | |
|---|---|
| chain | The Interceptor.Chain representing the intercepted network request. |
