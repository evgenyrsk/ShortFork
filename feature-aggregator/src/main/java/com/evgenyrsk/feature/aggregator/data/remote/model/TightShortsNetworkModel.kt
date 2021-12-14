package com.evgenyrsk.feature.aggregator.data.remote.model

import com.google.gson.annotations.SerializedName

data class TightShortsNetworkModel(

    @SerializedName("chart")
    val chart: List<Chart>,

    @SerializedName("current_short_volume")
    val currentShortVolume: Double
) {

    data class Chart(

        @SerializedName("regularVolArr")
        val regularVolumes: List<Int>,

        @SerializedName("shortVolArr")
        val shortVolumes: List<Int>,

        @SerializedName("xAxisArr")
        val dates: List<String>
    )
}
