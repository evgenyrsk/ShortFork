package com.evgenyrsk.feature.aggregator.data

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 *
 * Network DTO.
 */
data class AggregatorApiModel(

    @SerializedName("ticker")
    val ticker: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("site")
    val siteUrl: String?,

    @SerializedName("price")
    val price: Double?,

    @SerializedName("nakedChart")
    val nakedChart: NakedChartApiModel,

    @SerializedName("naked_current_short_volume")
    val nakedCurrentShortVolume: Double?,

    @SerializedName("pe")
    val pe: Double?,

    @SerializedName("ps")
    val ps: Double?,

    @SerializedName("pb")
    val pb: Double?,

    @SerializedName("roe")
    val roe: Double?,

    @SerializedName("roa")
    val roa: Double?,

    @SerializedName("rsi")
    val rsi: Double?,

    @SerializedName("squeeze_short_flow")
    val squeezeShortFloat: Double?,

    @SerializedName("finviz_short_flow")
    val finVizShortFloat: Double?,

    @SerializedName("tinkoff")
    val isAvailableOnTinkoff: Boolean,

    @SerializedName("target_price")
    val targetPrice: Double?,

    @SerializedName("debteq")
    val debtEq: Double?,

    @SerializedName(value = "recomendation", alternate = ["recommendation"])
    val finVizRecommendation: Double?,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("updatedAt")
    val updatedAt: String
)

data class NakedChartApiModel(

    @SerializedName("regularVolArr")
    val regularVolumes: List<Long>,

    @SerializedName("shortVolArr")
    val shortVolumes: List<Long>,

    @SerializedName("xAxisArr")
    val dates: List<String>
)
