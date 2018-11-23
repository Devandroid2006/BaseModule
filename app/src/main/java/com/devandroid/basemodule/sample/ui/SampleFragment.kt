package com.devandroid.basemodule.sample.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.model.BaseDataModel
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.adapter.SampleAdapter
import com.devandroid.basemodule.sample.model.SampleDataModel
import com.devandroid.basemodule.ui.BaseFragment
import com.devandroid.basemodule.utils.attachVerticalManager
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
        //prepare dummy data
        val list = listOf<BaseDataModel>(
            SampleDataModel("1"), SampleDataModel("2"),
            SampleDataModel("1"), SampleDataModel("2"), SampleDataModel("1"), SampleDataModel("2")
            , SampleDataModel("1"), SampleDataModel("2"), SampleDataModel("1"), SampleDataModel("2")
        )
        listView.adapter = sampleAdapter
        listView.attachVerticalManager()
        sampleAdapter.updateModelList(list)

    }

}
