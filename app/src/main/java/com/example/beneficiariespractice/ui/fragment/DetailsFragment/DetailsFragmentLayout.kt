package com.example.beneficiariespractice.ui.fragment.DetailsFragment

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.beneficiariespractice.ui.activity.MainViewModel
import com.example.beneficiariespractice.utils.LayoutCreator

class DetailsFragmentLayout(
    private val cont: Context,
    private val viewModel: MainViewModel
) : LayoutCreator(cont) {

    override fun createLayout(): ViewGroup {
        val linearLayout = createLinearLayout()
        val textView = TextView(cont)

        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.text = "DETAILS FRAGMENT"
        textView.textSize = 28F
        textView.gravity = Gravity.CENTER_HORIZONTAL
        linearLayout.addView(textView)
        return linearLayout
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