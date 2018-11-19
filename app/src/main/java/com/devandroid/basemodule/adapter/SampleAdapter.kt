package com.devandroid.basemodule.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.R
import com.devandroid.basemodule.model.BaseDataModel
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class SampleAdapter : BaseRcAdapter<BaseDataModel, SampleAdapter.SampleHolder>() {

    override fun bindView(holder: SampleAdapter.SampleHolder, model: BaseDataModel) {
        holder.name?.text = model.name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SampleAdapter.SampleHolder {
        val view = parent?.inflate(R.layout.row_sample)
        return SampleHolder(view)
    }

    class SampleHolder(view: View?) : BaseRcAdapter.BaseVHolder(view as View) {
        val name = view?.findViewById<TextView>(R.id.name);
    }
}