package com.devandroid.basemodule.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.devandroid.basemodule.BuildConfig
import com.devandroid.basemodule.R
import com.devandroid.basemodule.ui.BaseActivity
import com.devandroid.basemodule.ui.BaseFragment

/**
 * show toast for long duration
 */
fun Context.showLongDurationToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * show toast for short duration
 */
fun Context.showShortDurationToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * convert layout id to view
 */
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

/**
 * replace a fragment with back stack support
 */
fun BaseActivity.replaceWith(container: Int, baseFragment: BaseFragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(container, baseFragment, baseFragment.getTAG())
        //add to back stack if required
        .addToBackStack(if (baseFragment.isAddToBackStack) getTAG() else null)
        .commit()
}

/**
 * add a fragment with back stack support
 */
fun BaseFragment.attachTo(container: Int) {
    //return if manager is null
    val manager = activity?.supportFragmentManager ?: return
    manager
        .beginTransaction()
        .add(container, this, getTAG())
        //add to back stack if required
        .addToBackStack(if (isAddToBackStack) getTAG() else null)
        .commit()
}

/**
 * show non cancelable alert dialog with the given message
 */
fun BaseActivity.showNonCancelableAlert(message: String) {
    val dialog = AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, null)
        .setCancelable(false)
        .create()
    dialog.show()
    val textView = dialog.findViewById<TextView>(R.id.message)
    textView?.maxLines = 5
    textView?.movementMethod = ScrollingMovementMethod.getInstance()
}

/**
 * show non cancelable alert dialog with the given message
 */
fun BaseActivity.showNonCancelableAlert(message: String, listener: DialogInterface.OnClickListener) {
    val dialog = AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, listener)
        .setNegativeButton(R.string.cancel, null)
        .setCancelable(false)
        .create()
    dialog.show()
    val textView = dialog.findViewById<TextView>(R.id.message)
    textView?.maxLines = 5
    textView?.movementMethod = ScrollingMovementMethod.getInstance()
}

/**
 * check for the internet availability
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityService = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityService.activeNetworkInfo
    return activeNetworkInfo.isConnected
}

/**
 * print the logs for debug variant
 */
@SuppressLint("LogNotTimber")
fun Any.logdd(message: String) {
    if (BuildConfig.DEBUG) {
        //executing method name
        val methodName = Thread.currentThread().stackTrace.get(3).methodName
        Log.d(String.format("%s.%s", javaClass.simpleName, methodName), message)
    }
}

/**
 * print the logs for debug variant
 */
@SuppressLint("LogNotTimber")
fun Any.logee(message: String) {
    if (BuildConfig.DEBUG) {
        //get the name of the caller function
        val methodName = Thread.currentThread().stackTrace.get(3).methodName
        Log.e(String.format("%s.%s", javaClass.simpleName, methodName), message)
    }
}

/**
 * print the logs on console
 */
fun Any.printll(message: String) {
    if (BuildConfig.DEBUG) {
        //get the name of the caller function
        val methodName = Thread.currentThread().stackTrace.get(2).methodName
        println(String.format("%s.%s :%s", javaClass.simpleName, methodName, message))
    }
}

fun RecyclerView.attachVerticalManager() {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}

fun RecyclerView.attachHorizontalManager() {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}

