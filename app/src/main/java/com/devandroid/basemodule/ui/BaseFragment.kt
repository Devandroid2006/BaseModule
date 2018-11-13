package com.devandroid.basemodule.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devandroid.basemodule.utils.inflate

abstract class BaseFragment : Fragment() {

    //used to set add the fragment to back stack or not
    //by default it wont back stack
    open var isAddToBackStack = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(getLayoutId())
    }

    /**
     * return the tag name for the class
     */
    open fun getTAG(): String {
        return javaClass.simpleName
    }

    /**
     * return the layout id for the fragment
     */
    abstract fun getLayoutId(): Int

}