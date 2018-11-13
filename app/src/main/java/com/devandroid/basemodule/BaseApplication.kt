package com.devandroid.basemodule

import android.support.multidex.MultiDexApplication

class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        //do initial config
    }

}