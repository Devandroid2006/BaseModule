package com.devandroid.basemodule.network;

import java.util.Map;

public interface INetworkManager<T> {

    T getClient();

    String getBaseUrl();

    long getTimeout();

    Map<String, String> getHeaders();

}
