package com.devandroid.basemodule.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        logdd("called")
        //handle the navigation button back arrow
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            //consume the home button press
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        logdd("called")
        //back stack entry is 1 then kill the activity
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount > 0) {
            val baseFragment = supportFragmentManager.fragments[0] as BaseFragment
            if (null != baseFragment && baseFragment.isNotifyBackPress()) {
                baseFragment.handleBackPressed()
            } else {
                if (backStackEntryCount == 1) {
                    finish()
                    //finish and return
                    return
                }
                super.onBackPressed()
            }
        } else {
            finish()
        }
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
