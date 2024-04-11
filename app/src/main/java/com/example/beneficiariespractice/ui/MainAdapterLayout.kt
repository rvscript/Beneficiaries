package com.example.beneficiariespractice.ui

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
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
}