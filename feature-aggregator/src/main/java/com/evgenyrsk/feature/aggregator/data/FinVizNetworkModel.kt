package com.evgenyrsk.feature.aggregator.data

import com.google.gson.annotations.SerializedName

data class FinVizNetworkModel(

    @SerializedName("debteq")
    val debtEq: Double?,

    @SerializedName("dividend_percent")
    val dividendPercent: Double?,

    @SerializedName("name")
    val name: String,

    @SerializedName("pb")
    val pb: Double?,

    @SerializedName("pe")
    val pe: Double?,

    @SerializedName("peg")
    val peg: Double?,

    @SerializedName("price")
    val price: Double?,

    @SerializedName("ps")
    val ps: Double?,

    @SerializedName(value = "recomendation", alternate = ["recommendation"])
    val recommendation: Double?,

    @SerializedName("roa")
    val roa: Double?,

    @SerializedName("roe")
    val roe: Double?,

    @SerializedName("rsi")
    val rsi: Double?,

    @SerializedName("short_flow")
    val shortFlow: Double?,

    @SerializedName("site")
    val site: String?,

    @SerializedName("target_price")
    val targetPrice: Double
)
