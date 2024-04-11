package com.example.beneficiariespractice.ui.activity

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.beneficiariespractice.data.models.Beneficiaries
import com.example.beneficiariespractice.data.repos.MainRepositoryImpl
import com.example.beneficiariespractice.ui.MainAdapter
import com.example.beneficiariespractice.ui.MainViewModel
import com.example.beneficiariespractice.ui.ViewModelFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var layoutClass: MainActivityLayout
    lateinit var layout: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepositoryImpl()))[MainViewModel::class.java]
        layoutClass = MainActivityLayout(this@MainActivity, viewModel)
        layout = layoutClass.createLayout()
        setContentView(layout)
        createRecyclerView()
    }

    private fun createRecyclerView() {
        val mRecyclerView = layoutClass.recyclerView
        viewModel._data.observe(this) {
            if (it.isNotEmpty()) {
                mRecyclerView.apply {
                    adapter = MainAdapter(it)
                }
            }
        }
    }
}

