package com.example.beneficiariespractice.ui.adapter

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiariespractice.utils.LayoutCreator

class MainAdapterLayout(contxt: Context): LayoutCreator(contxt) {
    lateinit var mLayout: LinearLayout
    override fun createLayout(): ViewGroup {
        mLayout = createLinearLayout(LinearLayout.VERTICAL)
        mLayout.gravity = Gravity.CENTER
        mLayout.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
        return mLayout
    }

    fun createTextViewLayout(context: Context): TextView {
        val textView = TextView(context)
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView.textSize = 22F
        return textView
    }

}