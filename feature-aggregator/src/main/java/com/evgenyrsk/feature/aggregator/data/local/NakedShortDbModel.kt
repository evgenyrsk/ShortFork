package com.evgenyrsk.feature.aggregator.data.local

data class NakedShortDbModel(
    val chart: List<ChartDbModel>,
    val currentShortVolume: Double
)
