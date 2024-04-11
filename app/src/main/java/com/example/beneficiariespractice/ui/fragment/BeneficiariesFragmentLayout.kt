package com.example.beneficiariespractice.ui.fragment

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiariespractice.ui.activity.MainViewModel
import com.example.beneficiariespractice.utils.LayoutCreator

class BeneficiariesFragmentLayout(
    private val cont: Context,
    private val viewModel: MainViewModel
): LayoutCreator(cont) {
    val recyclerView = RecyclerView(cont)

    override fun createLayout(): ViewGroup {
        val linearLayout = createLinearLayout()
        linearLayout.gravity = Gravity.CENTER_HORIZONTAL
        linearLayout.setPadding(16, 16, 16, 16)
        val textView = TextView(cont)
        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.text = "BENEFICIARIES"
        textView.textSize = 28F
        textView.gravity = Gravity.CENTER_HORIZONTAL
        textView.setPadding(0, 20, 0, 0)

        val params = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.MATCH_PARENT
        )

        recyclerView.layoutParams = params
        recyclerView.setBackgroundColor(Color.WHITE)
        val linearLayoutMgr = LinearLayoutManager(cont)
        recyclerView.layoutManager = linearLayoutMgr
        recyclerView.visibility = View.VISIBLE

        linearLayout.addView(textView)
        linearLayout.addView(recyclerView)

        return linearLayout
    }
}