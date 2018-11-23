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
        val view = parent.inflate(R.layout.list_item_todo)
        return SampleHolder(view)
    }

    override fun bindView(holder: ToDosAdapter.SampleHolder, model: ToDoInfo) {
        holder.title.text = model.userId.toString()
        holder.body.text = model.title
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val title = view.findViewById<TextView>(R.id.title);
        val body = view.findViewById<TextView>(R.id.body);
    }
}