package com.evgenyrsk.feature.aggregator.presentation.model

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsModel(

    // Name of the company
    val ticker: String,

    // Forward Price / Net Income
    val pe: Double? = null,

    // Forward Price / Net Income
    val forwardPE: Double? = null,

    // Price / Sales Ratio
    val ps: Double? = null,

    // Price / Book Value
    val pb: Double? = null,

    // Price to Earnings Growth
    val peg: Double? = null,

    // Return on Equity
    val roe: Double? = null,

    // Return on Assets
    val roa: Double? = null,

    // Debt to Equity ratio
    val debtEq: Double? = null,

    // Stock's market price
    val marketPrice: Double? = null,

    // Stock's dividends
    val dividends: Double? = null,

    // TightShort.ru Short Volume
    val shortVolumeFromTightShort: Double? = null,

    // Short Float from shortsqueeze.com
    val shortFloatFromShortSqueeze: Double? = null,

    // Short Float from finviz
    val shortFloatFromFinViz: Double? = null,

    // Whether available on Tinkoff or not
    val isAvailableOnTinkoff: Boolean,

    // Target price
    val targetPrice: Double? = null,

    // Relative Strength Index
    val rsi: Double? = null
)
