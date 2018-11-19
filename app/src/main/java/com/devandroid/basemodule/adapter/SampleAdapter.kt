package com.devandroid.basemodule.adapter

import android.view.View
import android.view.ViewGroup
import com.devandroid.basemodule.model.BaseDataModel
import com.devandroid.basemodule.ui.BaseRcAdapter

class SampleAdapter : BaseRcAdapter<BaseDataModel, BaseRcAdapter.BaseVHolder>() {

    override fun bindView(holder: BaseVHolder, model: BaseDataModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseVHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
    }
}