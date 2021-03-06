package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.model.PostInfo
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class PostsAdapter : BaseRcAdapter<PostInfo, PostsAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = parent.inflate(R.layout.list_item_post)
        return SampleHolder(view)
    }

    override fun bindView(holder: PostsAdapter.SampleHolder, model: PostInfo) {
        holder.title.text = model.title
        holder.body.text = model.body
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val title = view.findViewById<TextView>(R.id.title);
        val body = view.findViewById<TextView>(R.id.body);
    }
}