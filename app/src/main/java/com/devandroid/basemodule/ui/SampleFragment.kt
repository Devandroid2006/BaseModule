package com.devandroid.basemodule.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.R

/**
 * A simple [Fragment] subclass.
 *
 */
class SampleFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_sample
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}
