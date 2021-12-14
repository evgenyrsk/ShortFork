package com.evgenyrsk.feature.aggregator.domain.model

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
data class TechnicalIndicatorsDomainModel(
    val pe: Double?,
    val forwardPe: Double?,
    val ps: Double?,
    val pb: Double?,
    val peg: Double?,
    val roe: Double?,
    val roa: Double?,
    val debtEq: Double?,
    val instOwn: Double?,
    val insiderOwn: Double?,
    val priceInDollars: Double?,
    val dividendsPercent: Double?,
    val beta: Double?,
    val tightShortVolume: Double?,
    val squeezeShortFloat: Double?,
    val finVizShortFloat: Double?,
    val shortInterestRatio: Double?,
    val isAvailableOnTinkoff: Boolean,
    val targetPriceUpside: Double?,
    val rsi: Double?,
    val finVizRecommendation: Double?
)
