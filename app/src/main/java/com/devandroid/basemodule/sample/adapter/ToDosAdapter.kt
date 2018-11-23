package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.model.ToDoInfo
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class ToDosAdapter : BaseRcAdapter<ToDoInfo, ToDosAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = parent.inflate(R.layout.row_sample)
        return SampleHolder(view)
    }

    override fun bindView(holder: ToDosAdapter.SampleHolder, model: ToDoInfo) {
//        holder.name.text = model.name
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val name = view.findViewById<TextView>(R.id.name);
    }
}