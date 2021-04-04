package com.evgenyrsk.feature.aggregator.data.shortsqueeze

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

/**
 * @author Evgeny Rasskazov
 */
class ShortSqueezeNetworkDataSource(
    private val baseUrl: String,
    private val responseParser: ShortSqueezeHtmlDocumentParser
) : RemoteDataSource<ShortSqueezeApiModel> {

    override suspend fun getShortData(companyTicker: String): ApiResponse<ShortSqueezeApiModel> {
        return withContext(Dispatchers.IO) {
            val url = StringBuilder(baseUrl).append("?symbol=${companyTicker}").toString()
            val document = Jsoup.connect(url)
                .timeout(10000)
                .get() ?: return@withContext ApiResponse.Error(Exception("Source is not available"))
            responseParser.parse(document)
        }
    }
}
