package com.evgenyrsk.feature.aggregator.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
data class BarChartFinancialsNetworkModel(

    @SerializedName("longTermDebt")
    val longTermDebt: List<Long>?,

    @SerializedName("shareholdersEquity")
    val shareHoldersEquity: List<Long>?,

    @SerializedName("netIncome")
    val netIncome: List<Long>?,

    @SerializedName("revenue")
    val revenue: List<Long>?,

    @SerializedName("dates")
    val dates: List<String>?
)