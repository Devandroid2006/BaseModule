package com.devandroid.basemodule.sample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.apis.ApiClient
import com.devandroid.basemodule.ui.BaseActivity
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.logee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SampleMainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_sample
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //replace the fragment with container
//        val sampleFragment = SampleFragment.newInstance
//        replaceWith(R.id.container, sampleFragment)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        logdd("called")
        menuInflater.inflate(R.menu.sample_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        logdd("called")
        when (item?.itemId) {
            R.id.action_comments -> {
                handleCommentsAction()
            }
            R.id.action_albums -> {
                handleAlbumsAction()
            }
            R.id.action_photos -> {
                handlePhotsAction()
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
        return super.onOptionsItemSelected(item)
    }

    private fun handlePostsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                }, {
                    logee(it.localizedMessage)
                })
        )

    }

    private fun handleToDosAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getToDos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                }, {
                    logee(it.localizedMessage)
                })
        )

    }

    private fun handlePhotsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                }, {
                    logee(it.localizedMessage)
                })
        )

    }

    private fun handleAlbumsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                }, {
                    logee(it.localizedMessage)
                })
        )
    }

    private fun handleCommentsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                }, {
                    logee(it.localizedMessage)
                })
        )

    }
}
