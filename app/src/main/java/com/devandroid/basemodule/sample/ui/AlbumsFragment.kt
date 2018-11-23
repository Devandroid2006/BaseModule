package com.devandroid.basemodule.sample.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.adapter.AlbumsAdapter
import com.devandroid.basemodule.sample.apis.ApiClient
import com.devandroid.basemodule.ui.BaseFragment
import com.devandroid.basemodule.utils.attachVerticalManager
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.logee
import com.devandroid.basemodule.utils.showNonCancelableAlert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.reusable_listview_layout.*

/**
 * A simple [Fragment] subclass.
 *
 */
class AlbumsFragment : BaseFragment() {

    companion object {
        val newInstance = AlbumsFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.reusable_listview_layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listView.attachVerticalManager()
        handleAlbumsAction()
    }

    private fun handleAlbumsAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                    val albumsAdapter = AlbumsAdapter()
                    listView.adapter = albumsAdapter
                    albumsAdapter.updateModelList(it)
                }, {
                    logee(it.localizedMessage)
                    activity?.showNonCancelableAlert(it.localizedMessage)
                })
        )
    }

}
