package com.evgenyrsk.core.data.api

import com.evgenyrsk.core.data.ShortSqueezeApi
import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.shortsqueeze.ShortSqueezeApiModel
import org.jsoup.Jsoup

/**
 * @author Evgeny Rasskazov
 */
class ShortSqueezeApiService(
    private val baseUrl: String,
    private val responseParser: ShortSqueezeHtmlDocumentParser
) : ShortSqueezeApi {

    override fun getShortData(companyTicker: String): Response<ShortSqueezeApiModel> {
        val url = StringBuilder(baseUrl).append("?symbol=${companyTicker}").toString()
        val document = Jsoup.connect(url).get() ?: return Response.error(null, "AAAAA")

        //        var squeezeApiModel = ShortSqueezeApiModel(
        //
        //        )
        //
        //        val htmlString = document.body().html()
        //        val htmlPageText = Jsoup.parse(htmlString).text()

        return responseParser.parse(document)
    }
}
