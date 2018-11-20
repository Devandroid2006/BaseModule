package com.devandroid.basemodule.sample.ui

import android.os.Bundle
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.utils.replaceWith

class SampleMainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_sample
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //replace the fragment with container
        SampleFragment.newInstance.replaceWith(R.id.container)
    }
}
