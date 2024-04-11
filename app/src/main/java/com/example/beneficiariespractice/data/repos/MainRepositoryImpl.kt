package com.example.beneficiariespractice.data.repos

import android.util.Log
import com.example.beneficiariespractice.data.models.BeneficiariesItem
import com.example.beneficiariespractice.data.models.BeneficiaryAddress
import com.example.beneficiariespractice.utils.Constants
import org.json.JSONArray
import org.json.JSONObject

class MainRepositoryImpl : MainRepository {
    val TAG = this::class.java.simpleName
    override suspend fun requestBeneficiaries(): List<BeneficiariesItem> {
        val jsonString = Constants.BENEFICIARIES
        return parseBeneficiariesItem(jsonString)
    }

    private fun parseBeneficiariesItem(jsonString: String): List<BeneficiariesItem> {
        val beneficiaries = mutableListOf<BeneficiariesItem>()
        val jsonArray = JSONArray(jsonString)
        try {
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val beneficiary = BeneficiariesItem(
                    jsonObject.getString("beneType"),
                    parseBeneficiaryAddress(
                        jsonObject.getJSONObject("beneficiaryAddress")
                    ),
                    jsonObject.getString("dateOfBirth"),
                    jsonObject.getString("designationCode"),
                    jsonObject.getString("firstName"),
                    jsonObject.getString("lastName"),
                    jsonObject.getString("middleName"),
                    jsonObject.getString("phoneNumber"),
                    jsonObject.getString("socialSecurityNumber")
                )

                beneficiaries.add(beneficiary)
            }
        } catch (e: Exception) {
            Log.e(
                TAG,
                "parseBeneficiariesItem: ERROR Parsing ${e.printStackTrace()},\n${e.localizedMessage}",
            )
        }
        return beneficiaries
    }

    private fun parseBeneficiaryAddress(addressObject: JSONObject): BeneficiaryAddress {
        return BeneficiaryAddress(
            firstLineMailing = addressObject.getString("firstLineMailing"),
            scndLineMailing = addressObject.optString("scndLineMailing", null),
            city = addressObject.getString("city"),
            zipCode = addressObject.getString("zipCode"),
            stateCode = addressObject.getString("stateCode"),
            country = addressObject.getString("country")
        )
    }

}
