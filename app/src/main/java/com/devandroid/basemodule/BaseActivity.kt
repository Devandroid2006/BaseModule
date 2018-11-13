package com.devandroid.basemodule

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        //default orientation of the activity will be portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    /**
     * get tag name for the activity
     */
    open fun getTAG(): String {
        return javaClass.simpleName
    }

    /**
     * pass layout id form implemented classes
     */
    abstract fun getLayoutId(): Int
}
