package com.evgenyrsk.feature.aggregator.domain.model

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
data class MainCompanyInfoDomainModel(
    val ticker: String,
    val name: String?,
    val siteUrl: String?
)