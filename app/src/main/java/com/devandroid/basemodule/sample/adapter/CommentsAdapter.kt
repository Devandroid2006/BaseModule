package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.model.CommentInfo
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class CommentsAdapter : BaseRcAdapter<CommentInfo, CommentsAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = parent.inflate(R.layout.list_item_comment)
        return SampleHolder(view)
    }

    override fun bindView(holder: CommentsAdapter.SampleHolder, model: CommentInfo) {
//        holder.name.text = model.sample
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
//        val name = view.findViewById<TextView>(R.id.name);
    }
}