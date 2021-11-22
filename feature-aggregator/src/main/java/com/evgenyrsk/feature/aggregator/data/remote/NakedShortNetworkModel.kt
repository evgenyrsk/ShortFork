package com.evgenyrsk.feature.aggregator.data.remote

import com.google.gson.annotations.SerializedName

data class NakedShortNetworkModel(

    @SerializedName("chart")
    val chart: List<ChartNetworkModel>,

    @SerializedName("current_short_volume")
    val currentShortVolume: Double
)
