package com.example.beneficiariespractice.data.models

data class BeneficiaryAddress(
    val city: String = "",
    val country: String = "",
    val firstLineMailing: String = "",
    val scndLineMailing: Any,
    val stateCode: String = "",
    val zipCode: String = ""
)