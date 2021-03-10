package com.evgenyrsk.core.nakedshort.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.nakedshort.model.NakedShortApiModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortService {

    @GET("ajax.php?action=getcompanyinfo")
    fun getShortData(
        @Query("company") companyTicker: String
    ): Response<NakedShortApiModel>
}
