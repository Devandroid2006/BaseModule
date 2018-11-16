package com.devandroid.basemodule.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * base retrofit network manager for the network calls
 * impl classes must provide the base url and the type of the service
 *
 * @param <T> service type
</T> */

abstract class BaseRetrofitManager<T> {

    val retrofitClient: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHTTPClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /**
     * configure the okhttp client
     *
     * @return okhttp client
     */
    //prepare headers
    val okHTTPClient: OkHttpClient
        get() {
            val httpClient = OkHttpClient().newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(interceptor)

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val headers = headers
                val requestBuilder = original.newBuilder()
                for ((key, value) in headers) {
                    requestBuilder.addHeader(key, value)
                }
                chain.proceed(requestBuilder.build())
            }

            return httpClient.build()
        }


    /**
     * @return the header parameters
     */
    open val headers: Map<String, String>
        get() {
            val params = HashMap<String, String>()
            params["Accept"] = "application/json"
            params["Content-Type"] = "application/json"
            return params
        }

    /**
     * get the base url for the service
     *
     * @return base url
     */
    abstract val baseUrl: String


    /**
     * create service for the given interface
     *
     * @param service service interface
     * @return service interface
     */
    fun createService(service: Class<T>): T {
        return retrofitClient.create(service)
    }

    companion object {

        private val DEFAULT_TIMEOUT: Long = 60
    }
}
