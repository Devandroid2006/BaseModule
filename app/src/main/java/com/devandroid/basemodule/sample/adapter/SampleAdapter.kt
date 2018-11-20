package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.R
import com.devandroid.basemodule.sample.model.BaseDataModel
import com.devandroid.basemodule.sample.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class SampleAdapter : BaseRcAdapter<BaseDataModel, SampleAdapter.SampleHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SampleHolder {
        val view = p0.inflate(R.layout.row_sample)
        return SampleHolder(view)
    }

    override fun bindView(holder: SampleAdapter.SampleHolder, model: BaseDataModel) {
        holder.name.text = model.name
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val name = view?.findViewById<TextView>(R.id.name);
    }
}