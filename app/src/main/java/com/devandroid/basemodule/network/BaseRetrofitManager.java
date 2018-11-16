package com.devandroid.basemodule.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * base retrofit network manager for the network calls
 * impl classes must provide the base url and the type of the service
 *
 * @param <T> service type
 */

public abstract class BaseRetrofitManager<T> {

    private static final long DEFAULT_TIMEOUT = 60;

    public Retrofit getRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getOkHTTPClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * configure the okhttp client
     *
     * @return okhttp client
     */
    public OkHttpClient getOkHTTPClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                final Request original = chain.request();
                //prepare headers
                final Map<String, String> headers = getHeaders();
                final Request.Builder requestBuilder = original.newBuilder();
                for (Map.Entry entry : headers.entrySet()) {
                    requestBuilder.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
                return chain.proceed(requestBuilder.build());
            }
        });

        return httpClient.build();
    }


    /**
     * @return the header parameters
     */
    public Map<String, String> getHeaders() {
        final HashMap<String, String> params = new HashMap<>();
        params.put("Accept", "application/json");
        params.put("Content-Type", "application/json");
        return params;
    }


    /**
     * create service for the given interface
     *
     * @param service service interface
     * @return service interface
     */
    public T createService(Class<T> service) {
        return getRetrofitClient().create(service);
    }

    /**
     * get the base url for the service
     *
     * @return base url
     */
    public abstract String getBaseUrl();
}
