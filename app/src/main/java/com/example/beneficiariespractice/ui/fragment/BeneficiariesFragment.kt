package com.example.beneficiariespractice.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.beneficiariespractice.data.models.BeneficiariesItem
import com.example.beneficiariespractice.data.repos.MainRepositoryImpl
import com.example.beneficiariespractice.ui.DetailsClickListener
import com.example.beneficiariespractice.ui.MainAdapter
import com.example.beneficiariespractice.ui.ViewModelFactory
import com.example.beneficiariespractice.ui.activity.MainViewModel
import com.example.beneficiariespractice.utils.Constants

class BeneficiariesFragment : Fragment(), DetailsClickListener {
    lateinit var viewModel: MainViewModel
    lateinit var fragmentLayout: BeneficiariesFragmentLayout
    lateinit var layout: ViewGroup
    lateinit var detailsListener: DetailsClickListener
    var containerLayoutId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(MainRepositoryImpl())
        )[MainViewModel::class.java]
        fragmentLayout = BeneficiariesFragmentLayout(requireContext(), viewModel)
        layout = fragmentLayout.createLayout()
        containerLayoutId = arguments?.getInt(Constants.ARGS_KEY_LAYOUT_ID, 0) ?: 0

        createRecyclerView()
        detailsListener = this@BeneficiariesFragment
        return layout
    }

    private fun createRecyclerView() {
        val mRecyclerView = fragmentLayout.recyclerView
        viewModel.data.observe(requireActivity()) {
            if (it.isNotEmpty()) {
                mRecyclerView.apply {
                    adapter = MainAdapter(it, detailsListener)
                }
            }
        }
    }

    override fun onListItemClicked(view: View, beneficiary: BeneficiariesItem) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("NAME", "${beneficiary.firstName} ${beneficiary.lastName}")
        bundle.putString("SSN", beneficiary.socialSecurityNumber)
        bundle.putString("DOB", beneficiary.dateOfBirth)
        bundle.putString("PHONENUMBER", beneficiary.phoneNumber)
        detailsFragment.arguments = bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(containerLayoutId, detailsFragment)
            .addToBackStack("DETAILS_FRAGMENT")
            .commit()
    }
}