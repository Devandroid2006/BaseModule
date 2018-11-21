package com.devandroid.basemodule.sample.ui.widgets

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils.TruncateAt.MARQUEE
import android.util.AttributeSet

/**
 * supports marquee text with repeat limit infinite.
 */
class MarqueeTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        ellipsize = MARQUEE
        marqueeRepeatLimit = -1//repeat count infinite.
        setSingleLine(true)
        isSelected = true
        isFocusableInTouchMode = true
        isFocusable = true
        setHorizontallyScrolling(true)
    }
}
