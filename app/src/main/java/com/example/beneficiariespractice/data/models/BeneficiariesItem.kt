package com.example.beneficiariespractice.data.models

data class BeneficiariesItem(
    val beneType: String = "",
    val beneficiaryAddress: BeneficiaryAddress,
    val dateOfBirth: String = "",
    val designationCode: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val phoneNumber: String = "",
    val socialSecurityNumber: String = ""
)