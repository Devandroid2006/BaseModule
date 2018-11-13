package com.devandroid.basemodule.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devandroid.basemodule.R

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
fun AppCompatActivity.showNonCancelableAlert(message: String) {
    AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, null)
        .setCancelable(false)
        .create()
        .show()
}

/**
 * show non cancelable alert dialog with the given message
 */
fun AppCompatActivity.showNonCancelableAlert(message: String, listener: DialogInterface.OnClickListener) {
    AlertDialog.Builder(this)
        .setTitle(R.string.alert)
        .setMessage(message)
        .setPositiveButton(R.string.ok, listener)
        .setNegativeButton(R.string.cancel, null)
        .setCancelable(false)
        .create()
        .show()
}