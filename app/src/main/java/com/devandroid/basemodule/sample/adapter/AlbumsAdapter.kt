package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.model.AlbumInfo
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class AlbumsAdapter : BaseRcAdapter<AlbumInfo, AlbumsAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = parent.inflate(R.layout.list_item_album)
        return SampleHolder(view)
    }

    override fun bindView(holder: AlbumsAdapter.SampleHolder, model: AlbumInfo) {
        holder.title.text = model.userId.toString()
        holder.body.text = model.title
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val title = view.findViewById<TextView>(R.id.title);
        val body = view.findViewById<TextView>(R.id.body);
    }
}