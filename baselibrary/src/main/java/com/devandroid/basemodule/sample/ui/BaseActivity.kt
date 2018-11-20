package com.devandroid.basemodule.sample.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.printll

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logdd("called")
        setContentView(getLayoutId())
        //default orientation of the activity will be portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onStart() {
        super.onStart()
        logdd("called")
        printll("called")

    }

    override fun onRestart() {
        super.onRestart()
        logdd("called")
    }

    override fun onResume() {
        super.onResume()
        logdd("called")
    }

    override fun onPause() {
        super.onPause()
        logdd("called")
    }

    override fun onStop() {
        super.onStop()
        logdd("called")
    }

    override fun onDestroy() {
        super.onDestroy()
        logdd("called")
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
