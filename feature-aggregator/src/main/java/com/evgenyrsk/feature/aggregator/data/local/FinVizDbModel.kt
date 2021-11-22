package com.evgenyrsk.feature.aggregator.data.local

data class FinVizDbModel(
    val debtEq: Double?,
    val dividendPercent: Double?,
    val name: String,
    val pb: Double?,
    val pe: Double?,
    val peg: Double?,
    val price: Double?,
    val ps: Double?,
    val recommendation: Double?,
    val roa: Double?,
    val roe: Double?,
    val rsi: Double?,
    val shortFlow: Double?,
    val site: String?,
    val targetPrice: Double
)
