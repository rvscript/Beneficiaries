package com.example.beneficiariespractice.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

class ViewModelFactory(private val mainRepository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mainRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}