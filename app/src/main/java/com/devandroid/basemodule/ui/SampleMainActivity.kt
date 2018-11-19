package com.devandroid.basemodule.ui

import android.os.Bundle
import com.devandroid.basemodule.R

class SampleMainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_sample
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
