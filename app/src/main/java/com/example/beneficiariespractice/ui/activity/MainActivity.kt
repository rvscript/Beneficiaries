package com.example.beneficiariespractice.ui.activity

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.beneficiariespractice.data.repos.MainRepositoryImpl
import com.example.beneficiariespractice.ui.ViewModelFactory
import com.example.beneficiariespractice.ui.fragment.BeneficiariesFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var activityLayout: MainActivityLayout
    lateinit var layout: ViewGroup
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = ViewModelFactory(MainRepositoryImpl())
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        activityLayout = MainActivityLayout(this@MainActivity, viewModel)
        layout = activityLayout.createLayout()
        setContentView(layout)

        val fragmentBeneficiaries = BeneficiariesFragment()
        val bundle = Bundle()
        bundle.putInt("LAYOUT_ID", layout.id)
        fragmentBeneficiaries.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(layout.id, fragmentBeneficiaries)
            .commit()
    }
}

