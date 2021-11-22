package com.evgenyrsk.feature.aggregator.data.local

data class ChartDbModel(
    val regularVolumes: List<Int>,
    val shortVolumes: List<Int>,
    val dates: List<String>
)
