package com.devandroid.basemodule.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface IRetrofitManager<T> {

    /**
     * return the retrofit client
     */
    fun getRetrofit(): Retrofit

    /**
     * return the okhttp client
     */
    fun getOkHttpClient(): OkHttpClient

    /**
     * return the header parameters
     */
    fun getHeaderParams(): Map<String, String>

    /**
     * create ap service for the given interface
     */
    fun createService(T: Class<T>): T

    /**
     * return the base url
     */
    fun getBaseUrl(): String

    /**
     * return the timeout period
     */
    fun getTimeout(): Long;
}