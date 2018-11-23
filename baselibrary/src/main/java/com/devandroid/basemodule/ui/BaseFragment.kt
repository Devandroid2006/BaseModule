package com.devandroid.basemodule.ui

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
        logdd("called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logdd("called")
        return container?.inflate(getLayoutId())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logdd("called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logdd("called")
    }

    override fun onStart() {
        super.onStart()
        logdd("called")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logdd("called")
    }

    override fun onResume() {
        super.onResume()
        logdd("called")
    }

    override fun onPause() {
        super.onPause()
        logdd("called")
    }

    override fun onStop() {
        super.onStop()
        logdd("called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logdd("called")
    }

    override fun onDestroy() {
        super.onDestroy()
        logdd("called")
    }

    override fun onDetach() {
        super.onDetach()
        logdd("called")
    }


    /**
     * handle the back pres event
     */
    open fun handleBackPressed() {
        logdd("called")
        //do nothing
    }

    /**
     * return true if you want to handle back key press
     */
    open fun isNotifyBackPress(): Boolean {
        logdd("called")
        return false
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