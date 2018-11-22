package com.devandroid.basemodule.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface IRetrofitManager<T> {

    /**
     * return the retrofit client
     */
    fun getRetrofit(baseurl: String): Retrofit

    /**
     * return the okhttp client
     */
    fun getOkHttpClient(): OkHttpClient

    /**
     * return the header parameters
     */
    fun getHeaderParams(): Map<String, String>


    /**
     * return the timeout period
     */
    fun getTimeout(): Long;
}