package com.evgenyrsk.nakedshort.data.api

import com.evgenyrsk.nakedshort.data.model.ShortStockDataHistoryApiModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortService {

    @GET("ajax.php?action=getcompanyinfo")
    fun getShortStockDataHistory(
        @Query("action") action: String = DEFAULT_ACTION,
        @Query("company") companyTicker: String
    ): ShortStockDataHistoryApiModel

    private companion object {
        const val DEFAULT_ACTION = "getcompanyinfo"
    }
}
