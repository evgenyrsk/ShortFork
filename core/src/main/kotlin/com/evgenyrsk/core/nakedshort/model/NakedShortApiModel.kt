package com.evgenyrsk.core.nakedshort.model

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 */
data class NakedShortApiModel(

    @SerializedName("historicalShortVol")
    val historicalShortVolumes: List<HistoricalShortVolApiModel>,

    @SerializedName("namets")
    val tickerName: String,

    @SerializedName("regularVolArr")
    val regularVolumes: List<Int>,

    @SerializedName("shortVolArr")
    val shortVolumes: List<Int>,

    @SerializedName("xAxisArr")
    val dates: List<String>
)
