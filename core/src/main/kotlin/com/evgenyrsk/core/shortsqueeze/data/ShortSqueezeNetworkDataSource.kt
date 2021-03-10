package com.evgenyrsk.core.shortsqueeze.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.shortsqueeze.model.ShortSqueezeApiModel
import org.jsoup.Jsoup

/**
 * @author Evgeny Rasskazov
 */
class ShortSqueezeNetworkDataSource(
    private val baseUrl: String,
    private val responseParser: ShortSqueezeHtmlDocumentParser
) : ShortSqueezeApi {

    override fun getShortData(companyTicker: String): Response<ShortSqueezeApiModel> {
        val url = StringBuilder(baseUrl).append("?symbol=${companyTicker}").toString()
        val document = Jsoup.connect(url).get() ?: return Response.error(null, "Source is not available")
        return responseParser.parse(document)
    }
}
