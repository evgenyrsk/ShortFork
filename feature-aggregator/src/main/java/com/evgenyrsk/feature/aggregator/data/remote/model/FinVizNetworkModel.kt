package com.evgenyrsk.feature.aggregator.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 */
data class FinVizNetworkModel(

    @SerializedName("beta")
    val beta: Double?,

    @SerializedName("country")
    val country: String?,

    @SerializedName("debteq")
    val debtEq: Double?,

    @SerializedName("dividend_percent")
    val dividendPercent: Double?,

    @SerializedName("exchange")
    val exchange: String?,

    @SerializedName("forwardPe")
    val forwardPe: Double?,

    @SerializedName("insiderOwn")
    val insiderOwn: Double?,

    @SerializedName("instOwn")
    val instOwn: Double?,

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

    @SerializedName("shortRatio")
    val shortRatio: Double?,

    @SerializedName("site")
    val site: String?,

    @SerializedName("target_price")
    val targetPrice: Double
)
