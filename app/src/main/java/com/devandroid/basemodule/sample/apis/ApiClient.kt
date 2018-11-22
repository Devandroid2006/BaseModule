package com.devandroid.basemodule.sample.apis

import com.devandroid.basemodule.network.RetrofitManager
import com.devandroid.basemodule.sample.apis.FakeWebService.Companion.BASE_URL

class ApiClient {

    companion object {

        fun provideFakeWebservice(): FakeWebService {
            return RetrofitManager.create(FakeWebService::class.java, BASE_URL);
        }
    }
}