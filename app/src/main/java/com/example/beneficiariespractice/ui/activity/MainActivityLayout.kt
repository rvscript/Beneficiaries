package com.example.beneficiariespractice.ui.activity

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import com.example.beneficiariespractice.utils.LayoutCreator

class MainActivityLayout (
    cont: Context,
    private val viewModel: MainViewModel
): LayoutCreator(cont) {
    val linearLayoutID = 5
    override fun createLayout(): ViewGroup {
        val linearLayout = createLinearLayout()
        linearLayout.gravity = Gravity.CENTER_HORIZONTAL
        linearLayout.setPadding(16, 16, 16, 16)
        linearLayout.id = linearLayoutID
        return linearLayout
    }
}