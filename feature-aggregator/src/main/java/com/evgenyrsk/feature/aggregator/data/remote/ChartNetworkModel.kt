package com.evgenyrsk.feature.aggregator.data.remote

import com.google.gson.annotations.SerializedName

data class ChartNetworkModel(

    @SerializedName("regularVolArr")
    val regularVolumes: List<Int>,

    @SerializedName("shortVolArr")
    val shortVolumes: List<Int>,

    @SerializedName("xAxisArr")
    val dates: List<String>
)
