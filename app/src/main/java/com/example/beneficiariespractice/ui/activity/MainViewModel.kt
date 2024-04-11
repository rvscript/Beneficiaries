package com.example.beneficiariespractice.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beneficiariespractice.data.models.BeneficiariesItem
import com.example.beneficiariespractice.data.repos.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {
    val _data = MutableLiveData<List<BeneficiariesItem>>()
    val data: LiveData<List<BeneficiariesItem>>
        get() = _data

    private fun getBeneficiaries() {
        CoroutineScope(Dispatchers.Default).launch {
            val result = repository.requestBeneficiaries()
            _data.postValue(result)
        }
    }

    init {
        getBeneficiaries()
    }
}