package com.evgenyrsk.feature.board.domain

import com.evgenyrsk.core.nakedshort.domain.NakedShortRepository
import com.evgenyrsk.core.shortsqueeze.domain.ShortSqueezeRepository

/**
 * @author Evgeny Rasskazov
 */
class GetShortDataUseCase(
    private val nakedShortRepository: NakedShortRepository,
    private val shortSqueezeRepository: ShortSqueezeRepository
) {

    suspend fun getShortData() {
    }
}
