package com.evgenyrsk.feature.aggregator.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
data class BarChartOverviewNetworkModel(

    @SerializedName("options")
    val options: Options,

    @SerializedName("analytics")
    val analytics: Analytics
) {

    data class Options(

        @SerializedName("impliedVolatility")
        val impliedVolatility: Double?,

        @SerializedName("historicalVolatility")
        val historicalVolatility: Double?,

        @SerializedName("ivPercentile")
        val ivPercentile: Double?,

        @SerializedName("ivRank")
        val ivRank: Double?,

        @SerializedName("putCallVolRatio")
        val putCallVolRatio: Double?,

        @SerializedName("todaysVolume")
        val todayVolume: Long?,

        @SerializedName("volumeAvg30Day")
        val avg30DaysVolume: Long?,

        @SerializedName("putCallOiRatio")
        val putCallOiRatio: Double?,

        @SerializedName("todaysOpenInterest")
        val todayOpenInterest: Long?,

        @SerializedName("openInt30Day")
        val open30DaysInterest: Long?
    )

    data class Analytics(

        @SerializedName("strongBuy")
        val strongBuy: Int?,

        @SerializedName("moderateBuy")
        val moderateBuy: Int?,

        @SerializedName("hold")
        val hold: Int?,

        @SerializedName("moderateSell")
        val moderateSell: Int?,

        @SerializedName("strongSell")
        val strongSell: Int?
    )
}