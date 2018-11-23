package com.devandroid.basemodule.sample.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.adapter.CommentsAdapter
import com.devandroid.basemodule.ui.BaseFragment

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
        val sampleAdapter = CommentsAdapter()
//       /* //prepare dummy data
//        val list = listOf<BaseDataModel>(
//            SampleDataModel("1"), SampleDataModel("2"),
//            SampleDataModel("1"), SampleDataModel("2"), SampleDataModel("1"), SampleDataModel("2")
//            , SampleDataModel("1"), SampleDataModel("2"), SampleDataModel("1"), SampleDataModel("2")
//        )*/
//        listView.adapter = sampleAdapter
//        listView.attachVerticalManager()
//        sampleAdapter.updateModelList(list)

    }

}
