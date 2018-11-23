package com.devandroid.basemodule.sample.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.adapter.PostsAdapter
import com.devandroid.basemodule.sample.apis.ApiClient
import com.devandroid.basemodule.ui.BaseFragment
import com.devandroid.basemodule.utils.attachVerticalManager
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.logee
import com.devandroid.basemodule.utils.showNonCancelableAlert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sample.*

/**
 * A simple [Fragment] subclass.
 *
 */
class PostsFragment : BaseFragment() {

    companion object {
        val newInstance = PostsFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sample
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listView.attachVerticalManager()
        handlePostsAction()
    }


    private fun handlePostsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                    val postsAdapter = PostsAdapter()
                    listView.adapter = postsAdapter
                    postsAdapter.updateModelList(it)

                }, {
                    logee(it.localizedMessage)
                    activity?.showNonCancelableAlert(it.localizedMessage)
                })
        )

    }

}
