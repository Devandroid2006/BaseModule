package com.devandroid.basemodule.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.R
import com.devandroid.basemodule.adapter.SampleAdapter
import com.devandroid.basemodule.model.BaseDataModel
import com.devandroid.basemodule.model.SampleDataModel
import kotlinx.android.synthetic.main.fragment_sample.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SampleFragment : BaseFragment() {

    companion object {
        val newInstance = SampleFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sample
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //listView.attachVerticalManager()
        val sampleAdapter = SampleAdapter()
        val list = listOf<BaseDataModel>(SampleDataModel("1"), SampleDataModel("2"))
        listView.adapter = sampleAdapter
        sampleAdapter.updateModelList(list)

    }


}
