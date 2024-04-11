package com.example.beneficiariespractice.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiariespractice.data.models.BeneficiariesItem
import com.example.beneficiariespractice.utils.Constants.CODE_CONTIGENT
import com.example.beneficiariespractice.utils.Constants.CODE_NOT_AVAIL
import com.example.beneficiariespractice.utils.Constants.CODE_PRIMARY

class MainAdapter(
    private val beneficiaries: List<BeneficiariesItem>,
    val detailsClickListener: DetailsClickListener
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    lateinit var mLayoutCreator: MainAdapterLayout
    lateinit var mLayout: LinearLayout
    lateinit var mTV_Name: TextView
    lateinit var mTV_beneType: TextView
    lateinit var mTV_designation: TextView

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(beneficiary: BeneficiariesItem) {
            mTV_Name.text = "${beneficiary.firstName}, ${beneficiary.lastName}"
            mTV_beneType.text = "${beneficiary.beneType}"
            mTV_designation.text = setDesignationCodeDescription(beneficiary.designationCode)

            mLayout.setOnClickListener { view ->
                detailsClickListener.onListItemClicked(view, beneficiary)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        mLayoutCreator = MainAdapterLayout(parent.context)
        mLayout = mLayoutCreator.createLinearLayout(height = LayoutParams.WRAP_CONTENT)

        mTV_Name = createTextViewLayout(parent.context)
        mLayout.addView(mTV_Name)

        mTV_beneType = createTextViewLayout(parent.context)
        mLayout.addView(mTV_beneType)

        mTV_designation = createTextViewLayout(parent.context)
        mLayout.addView(mTV_designation)

        return MainViewHolder(mLayout)
    }

    override fun getItemCount(): Int = beneficiaries.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(beneficiaries[position])
    }

    private fun createTextViewLayout(context: Context): TextView {
        val textView = TextView(context)
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView.textSize = 22F
        return textView
    }

    private fun setDesignationCodeDescription(code: String): String {
        return when (code) {
            "P" -> CODE_PRIMARY
            "C" -> CODE_CONTIGENT
            else -> CODE_NOT_AVAIL
        }
    }
}

interface DetailsClickListener {
    fun onListItemClicked(view: View, beneficiary: BeneficiariesItem)
}