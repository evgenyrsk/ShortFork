package com.evgenyrsk.core.shortsqueeze.model

/**
 * @author Evgeny Rasskazov
 */
data class ShortSqueezeApiModel(
    val name: String,
    val price: Double,
    val ticker: String,
    val shortData: List<Pair<String, Float>>
)
