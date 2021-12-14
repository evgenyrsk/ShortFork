package com.evgenyrsk.feature.aggregator.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 *
 * Network DTO.
 */
data class AggregatorNetworkModel(

    @SerializedName("ticker")
    val ticker: String,

    @SerializedName("finviz")
    val finViz: FinVizNetworkModel?,

    @SerializedName("barchartoverview")
    val barChartOverview: BarChartOverviewNetworkModel,

    @SerializedName("barchartfinancials")
    val barChartFinancials: BarChartFinancialsNetworkModel,

    @SerializedName("tightshorts")
    val tightShort: TightShortsNetworkModel?,

    @SerializedName("shortsqueeze")
    val shortSqueeze: ShortSqueezeNetworkModel?,

    @SerializedName("tinkoff")
    val isAvailableInTinkoff: Boolean?
)
