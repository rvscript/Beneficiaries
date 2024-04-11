package com.example.beneficiariespractice.utils

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout

abstract class LayoutCreator (val context: Context) {
    // Function to create a linearlayout
    fun createLinearLayout(orientation: Int = LinearLayout.VERTICAL, width: Int = ViewGroup.LayoutParams.MATCH_PARENT, height: Int = ViewGroup.LayoutParams.MATCH_PARENT): LinearLayout {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = orientation
        return linearLayout
    }

    // Function to create a relativelayout
    fun createRelativeLayout(): RelativeLayout {
        val relativeLayout = RelativeLayout(context)
        relativeLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return relativeLayout
    }

    // Function to create a framelayout
    fun createFrameLayout(): FrameLayout {
        val frameLayout = FrameLayout(context)
        frameLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return frameLayout
    }

    abstract fun createLayout(): ViewGroup
}
