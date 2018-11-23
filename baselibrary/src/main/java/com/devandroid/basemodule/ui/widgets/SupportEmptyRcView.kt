package com.devandroid.basemodule.ui.widgets

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

class SupportEmptyRcView : RecyclerView {

    private var emptyView: View? = null

    private val mEmptyObserver = object : RecyclerView.AdapterDataObserver() {

        override fun onChanged() {
            val adapter = adapter
            if (adapter != null && emptyView != null) {
                if (adapter.itemCount == 0) {
                    emptyView!!.visibility = View.VISIBLE
                    this@SupportEmptyRcView.visibility = View.GONE
                } else {
                    emptyView!!.visibility = View.GONE
                    this@SupportEmptyRcView.visibility = View.VISIBLE
                }
            }
        }
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(mEmptyObserver)
        mEmptyObserver.onChanged()
    }

    fun setEmptyView(emptyView: View) {
        this.emptyView = emptyView
    }
}