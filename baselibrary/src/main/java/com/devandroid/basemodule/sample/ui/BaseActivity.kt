package com.devandroid.basemodule.sample.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.devandroid.basemodule.utils.logdd

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logdd("onCreate")
        setContentView(getLayoutId())
        //default orientation of the activity will be portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onStart() {
        super.onStart()
        logdd("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        logdd("onRestart")
    }

    override fun onResume() {
        super.onResume()
        logdd("onResume")
    }

    override fun onPause() {
        super.onPause()
        logdd("onPause")
    }

    override fun onStop() {
        super.onStop()
        logdd("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logdd("onDestroy")
    }

    /**
     * get tag name for the activity
     */
    open fun getTAG(): String {
        return javaClass.simpleName
    }


    /**
     * return layout id for the activity
     */
    abstract fun getLayoutId(): Int
}
