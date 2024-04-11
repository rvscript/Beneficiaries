package com.example.beneficiariespractice.ui.fragment.DetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.beneficiariespractice.data.repos.MainRepositoryImpl
import com.example.beneficiariespractice.ui.ViewModelFactory
import com.example.beneficiariespractice.ui.activity.MainViewModel

class DetailsFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var fragmentLayout: DetailsFragmentLayout
    lateinit var layout: ViewGroup
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(MainRepositoryImpl())
        )[MainViewModel::class.java]

        val name = arguments?.getString("NAME")?: ""
        val ssn = arguments?.getString("SSN") ?: ""
        val dob = arguments?.getString("DOB") ?: ""
        val pn = arguments?.getString("PHONENUMBER") ?: ""

        fragmentLayout = DetailsFragmentLayout(requireContext(), viewModel)
        layout = fragmentLayout.createLayout()

        val mTV_name = fragmentLayout.createTextViewLayout(requireContext())
        mTV_name.text = name
        layout.addView(mTV_name)

        val mTV_ssn = fragmentLayout.createTextViewLayout(requireContext())
        mTV_ssn.text = ssn
        layout.addView(mTV_ssn)

        val mTV_dob = fragmentLayout.createTextViewLayout(requireContext())
        mTV_dob.text = dob
        layout.addView(mTV_dob)

        val mTV_pn = fragmentLayout.createTextViewLayout(requireContext())
        mTV_pn.text = pn
        layout.addView(mTV_pn)

        return layout
    }

}