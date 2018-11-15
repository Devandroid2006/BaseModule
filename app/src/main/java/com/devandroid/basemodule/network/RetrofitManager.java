package com.devandroid.basemodule.network;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RetrofitManager implements INetworkManager {

    private static final long DEFAULT_TIMEOUT = TimeUnit.SECONDS.toMillis(100);

    @Override
    public Object getClient() {
        return null;
    }

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    public long getTimeout() {
        return DEFAULT_TIMEOUT;
    }

    @Override
    public Map<String, String> getHeaders() {
        return null;
    }
}
