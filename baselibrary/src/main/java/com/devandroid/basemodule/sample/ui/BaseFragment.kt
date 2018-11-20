package com.devandroid.basemodule.sample.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devandroid.basemodule.utils.inflate
import com.devandroid.basemodule.utils.logdd

abstract class BaseFragment : Fragment() {

    //used to set add the fragment to back stack or not
    //by default it wont back stack
    open var isAddToBackStack = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logdd("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logdd("onCreateView")
        return container?.inflate(getLayoutId())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logdd("onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logdd("onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        logdd("onStart")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logdd("onViewStateRestored")
    }

    override fun onResume() {
        super.onResume()
        logdd("onResume")
    }

    override fun onPause() {
        super.onPause()
        logdd("onPause")
    }

    override fun onStop() {
        super.onStop()
        logdd("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logdd("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logdd("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logdd("onDetach")
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