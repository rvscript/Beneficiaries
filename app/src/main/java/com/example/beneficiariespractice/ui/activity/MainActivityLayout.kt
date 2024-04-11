package com.example.beneficiariespractice.ui.activity

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiariespractice.ui.MainViewModel
import com.example.beneficiariespractice.utils.LayoutCreator

class MainActivityLayout (
    private val cont: Context,
    private val viewModel: MainViewModel
): LayoutCreator(cont) {
    val recyclerView = RecyclerView(cont)

    override fun createLayout(): ViewGroup {
        val linearLayout = createLinearLayout(LinearLayout.VERTICAL)
        linearLayout.gravity = Gravity.CENTER
        val textView = TextView(cont)
        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.text = "BENEFICIARIES"
        textView.textSize = 28F
        textView.gravity = Gravity.CENTER

        val params = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )

        recyclerView.layoutParams = params
        val linearLayoutMgr = LinearLayoutManager(cont)
        recyclerView.layoutManager = linearLayoutMgr
        recyclerView.visibility = View.VISIBLE

        linearLayout.addView(textView)
        linearLayout.addView(recyclerView)

        return linearLayout
    }
}