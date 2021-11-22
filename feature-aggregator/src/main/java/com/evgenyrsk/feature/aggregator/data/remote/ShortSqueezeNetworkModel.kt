package com.evgenyrsk.feature.aggregator.data.remote

import com.google.gson.annotations.SerializedName

data class ShortSqueezeNetworkModel(

    @SerializedName("short_flow")
    val shortFlow: Double
)
