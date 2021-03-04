package com.evgenyrsk.core.data

import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.nakedshort.NakedShortApiModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortApi {

    @GET("ajax.php?action=getcompanyinfo")
    fun getShortData(
        @Query("company") companyTicker: String
    ): Response<NakedShortApiModel>
}
