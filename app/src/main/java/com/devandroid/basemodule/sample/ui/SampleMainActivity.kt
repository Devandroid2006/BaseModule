package com.devandroid.basemodule.sample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.ui.BaseActivity
import com.devandroid.basemodule.utils.isNetworkAvailable
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.replaceTo
import com.devandroid.basemodule.utils.showNonCancelableAlert

class SampleMainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_sample
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isNetworkAvailable()) {
            //load comments
            handleCommentsAction()
        } else {
            showNonCancelableAlert(getString(R.string.err_no_internet))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        logdd("called")
        menuInflater.inflate(R.menu.sample_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        logdd("called")
        if (isNetworkAvailable()) {
            when (item?.itemId) {
                R.id.action_comments -> {
                    handleCommentsAction()
                }
                R.id.action_albums -> {
                    handleAlbumsAction()
                }
                R.id.action_photos -> {
                    handlePhotosAction()
                }
                R.id.action_todos -> {
                    handleToDosAction()
                }
                R.id.action_posts -> {
                    handlePostsAction()
                }
                else -> {
                    //default nothing
                }
            }
        } else {
            showNonCancelableAlert(getString(R.string.err_no_internet))
        }
        return true
    }

    private fun handlePostsAction() {
        val baseFragment = PostsFragment.newInstance
        replaceTo(R.id.container, baseFragment)
    }

    private fun handleToDosAction() {
        val baseFragment = ToDosFragment.newInstance
        replaceTo(R.id.container, baseFragment)

    }

    private fun handlePhotosAction() {
        val baseFragment = PhotosFragment.newInstance
        replaceTo(R.id.container, baseFragment)

    }

    private fun handleAlbumsAction() {
        val baseFragment = AlbumsFragment.newInstance
        replaceTo(R.id.container, baseFragment)
    }

    private fun handleCommentsAction() {
        val baseFragment = CommentsFragment.newInstance
        replaceTo(R.id.container, baseFragment)
    }
}
