package com.devandroid.basemodule.sample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devandroid.basemodule.sample.R
import com.devandroid.basemodule.sample.model.PhotoInfo
import com.devandroid.basemodule.ui.BaseRcAdapter
import com.devandroid.basemodule.utils.inflate

class PhotosAdapter : BaseRcAdapter<PhotoInfo, PhotosAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = parent.inflate(R.layout.list_item_photo)
        return SampleHolder(view)
    }

    override fun bindView(holder: PhotosAdapter.SampleHolder, model: PhotoInfo) {
//        holder.name.text = model.name
    }

    class SampleHolder(view: View) : BaseRcAdapter.BaseVHolder(view) {
        val name = view.findViewById<TextView>(R.id.name);
    }
}