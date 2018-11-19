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

abstract class BaseRetrofitManager<T> : IRetrofitManager<T> {

    override fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    override fun getOkHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .connectTimeout(getTimeout(), TimeUnit.SECONDS)
            .readTimeout(getTimeout(), TimeUnit.SECONDS)
            .writeTimeout(getTimeout(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val headers = getHeaderParams()
                val requestBuilder = original.newBuilder()
                for ((key, value) in headers) {
                    requestBuilder.addHeader(key, value)
                }
                chain.proceed(requestBuilder.build())
            }.build()
    }

    override fun getHeaderParams(): Map<String, String> {
        val params = HashMap<String, String>()
        params["Accept"] = "application/json"
        params["Content-Type"] = "application/json"
        return params
    }

    override fun createService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

    override fun getTimeout(): Long {
        return DEFAULT_TIMEOUT
    }

    /**
     * constants
     */
    companion object {

        private val DEFAULT_TIMEOUT: Long = 60
    }
}
