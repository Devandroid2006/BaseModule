package com.devandroid.basemodule.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.devandroid.basemodule.utils.logdd

abstract class BaseRcAdapter<T, VH : BaseRcAdapter.BaseVHolder> : RecyclerView.Adapter<VH>() {

    var mList: List<T>

    init {
        mList = ArrayList<T>()
    }

    /**
     * update the data models and refresh the UI
     */
    fun updateModelList(list: List<T>) {
        logdd("called")
        mList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        logdd("called")
        return mList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VH {
        logdd("called")
        return super.createViewHolder(p0, p1)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        logdd("called")
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