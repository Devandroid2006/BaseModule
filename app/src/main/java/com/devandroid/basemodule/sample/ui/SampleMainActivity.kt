package com.devandroid.basemodule.sample.ui

import android.os.Bundle
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.apis.ApiClient
import com.devandroid.basemodule.utils.logdd
import com.devandroid.basemodule.utils.logee
import com.devandroid.basemodule.utils.replaceWith
import com.devandroid.basemodule.utils.showNonCancelableAlert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SampleMainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_sample
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //replace the fragment with container
        val sampleFragment = SampleFragment.newInstance
        replaceWith(R.id.container, sampleFragment)

        ApiClient.provideFakeWebservice().getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                logdd(it)
                showNonCancelableAlert(it)
            }, {
                logee(it.localizedMessage)
                showNonCancelableAlert(it.localizedMessage)
            })
    }
}
