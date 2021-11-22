package com.evgenyrsk.feature.aggregator.data.remote

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 *
 * Network DTO.
 */
// TODO need to actualize network DTO
data class AggregatorNetworkModel(

    @SerializedName("ticker")
    val ticker: String,

    @SerializedName("finviz")
    val finViz: FinVizNetworkModel?,

    @SerializedName("nakedshort")
    val nakedShort: NakedShortNetworkModel?,

    @SerializedName("shortsqueeze")
    val shortSqueeze: ShortSqueezeNetworkModel?,

    @SerializedName("tinkoff")
    val isAvailableInTinkoff: Boolean?
)
