package com.devandroid.basemodule.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.devandroid.basemodule.model.BaseDataModel
import com.devandroid.basemodule.utils.logdd

abstract class BaseRcAdapter<T : BaseDataModel, VH : BaseRcAdapter.BaseVHolder> : RecyclerView.Adapter<VH>() {

    lateinit var mList: List<T>

    /**
     * update the data models and refresh the UI
     */
    fun updateModelList(list: List<T>) {
        logdd(list.size.toString())
        mList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        logdd(String.format("Holder :%s, Position :%d", holder, position))
        //call bindview to update views of child's
        bindView(holder, mList.get(position))
    }

    /**
     * bind data to the view in child class
     */
    abstract fun bindView(holder: VH, model: T)


    /**
     * base view holder for the recycler view it be should implemented by the child classes
     */
    abstract class BaseVHolder(view: View) : RecyclerView.ViewHolder(view)

}