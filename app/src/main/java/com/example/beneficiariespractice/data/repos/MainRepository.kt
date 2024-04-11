package com.example.beneficiariespractice.data.repos

import com.example.beneficiariespractice.data.models.BeneficiariesItem

interface MainRepository {
    suspend fun requestBeneficiaries(): List<BeneficiariesItem>
}