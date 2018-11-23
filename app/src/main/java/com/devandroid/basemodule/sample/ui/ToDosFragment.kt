package com.devandroid.basemodule.sample.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.adapter.ToDosAdapter
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
class ToDosFragment : BaseFragment() {

    companion object {
        val newInstance = ToDosFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sample
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listView.attachVerticalManager()
        handleToDosAction()
    }


    private fun handleToDosAction() {
        mCompositeDisposable.add(
            ApiClient.provideFakeWebservice()
                .getToDos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logdd(it.toString())
                    val toDosAdapter = ToDosAdapter()
                    listView.adapter = toDosAdapter
                    toDosAdapter.updateModelList(it)
                }, {
                    logee(it.localizedMessage)
                    activity?.showNonCancelableAlert(it.localizedMessage)
                })
        )

    }
}
