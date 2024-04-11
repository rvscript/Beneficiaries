package com.example.beneficiariespractice.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiariespractice.data.models.BeneficiariesItem


class MainAdapter (
    private val beneficiaries: List<BeneficiariesItem>
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(beneficiary: BeneficiariesItem) {

        }
    }

    private fun createItemLayout(context: Context): ViewGroup {
        val layout = LinearLayout(context)
        layout.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layout.orientation = LinearLayout.VERTICAL

        val textView = TextView(context)
        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val textId = 5
        textView.id = textId
        textView.text = "Item View Text View"
        return layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(createItemLayout(parent.context))
    }

    override fun getItemCount():Int = beneficiaries.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(beneficiaries[position])
    }
}