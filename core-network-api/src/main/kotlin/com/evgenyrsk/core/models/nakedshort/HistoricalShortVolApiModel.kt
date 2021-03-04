package com.evgenyrsk.core.models.nakedshort

import com.google.gson.annotations.SerializedName

/**
 * @author Evgeny Rasskazov
 */
data class HistoricalShortVolApiModel(

    @SerializedName("0")
    val date: String,

    @SerializedName("5")
    val volume: String,

    @SerializedName("7")
    val shortVolume: String,

    @SerializedName("8")
    val percentOfVolumeShorted: String
)
