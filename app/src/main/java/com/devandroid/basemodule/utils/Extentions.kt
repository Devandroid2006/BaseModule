package com.devandroid.basemodule.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
 * show non cancelable alert dialog with the given message
 */
fun BaseActivity.showNonCancelableAlert(message: String) {
    AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, null)
        .setCancelable(false)
        .create()
        .show()
}

/**
 * replace a fragment with back stack support
 */
fun BaseActivity.replaceFragment(container: Int, fragment: BaseFragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(container, fragment, fragment.getTAG())
        //add to back stack if required
        .addToBackStack(if (fragment.isAddToBackStack) fragment.getTAG() else null)
        .commit()
}

/**
 * show non cancelable alert dialog with the given message
 */
fun BaseActivity.showNonCancelableAlert(message: String, listener: DialogInterface.OnClickListener) {
    AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, listener)
        .setNegativeButton(R.string.cancel, null)
        .setCancelable(false)
        .create()
        .show()
}