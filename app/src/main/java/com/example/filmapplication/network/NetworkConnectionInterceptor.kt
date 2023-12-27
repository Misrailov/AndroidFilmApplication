package com.example.filmapplication.network


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
/**
 * Interceptor for checking network connectivity before making network requests.
 *
 * @property context The [Context] used to check network connectivity.
 */
class NetworkConnectionInterceptor(val context: Context) : Interceptor {
    /**
     * Intercepts the network request and checks for network connectivity.
     *
     * @param chain The [Interceptor.Chain] representing the intercepted network request.
     * @return The [Response] of the network request if there is a connection; otherwise, an [IOException] is thrown.
     */
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        if(!isConnected(context=context)){
            Log.i("retrofit", "there is no connection")
            throw IOException()


        }
        else {
            val builder = chain.request().newBuilder()
            return@run chain.proceed(builder.build())
        }

    }
    /**
     * Checks if the device is connected to a network.
     *
     * @param context The [Context] used to check network connectivity.
     * @return `true` if the device is connected to a network, otherwise `false`.
     */
    fun isConnected(context: Context): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }

        return result
    }
}

