package com.evgenyrsk.feature.aggregator.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortService {

    @GET("ajax.php?action=getcompanyinfo")
    suspend fun getShortData(
        @Query("company") companyTicker: String
    ): Response<NakedShortApiModel>
}
