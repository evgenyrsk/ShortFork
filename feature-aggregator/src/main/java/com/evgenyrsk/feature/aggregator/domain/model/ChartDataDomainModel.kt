package com.evgenyrsk.feature.aggregator.domain.model

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
data class ChartDataDomainModel(
    val overallVolumes: List<Int>,
    val shortVolumes: List<Int>,
    val dates: List<String>
)
