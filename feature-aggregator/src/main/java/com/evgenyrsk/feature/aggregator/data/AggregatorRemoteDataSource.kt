package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRemoteDataSource @Inject constructor(
    private val service: AggregatorService
) : RemoteDataSource {

    override suspend fun getAllShortData(companyTicker: String): ApiResponse<NetworkModel> {
        return try {
            service.getAllData(companyTicker).toApiResponse()
        } catch (e: HttpException) {
            ApiResponse.Error(e)
        }
    }

    override suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortNetworkModel> {
        return try {
            service.getNakedShortData(companyTicker).toApiResponse()
        } catch (e: HttpException) {
            ApiResponse.Error(e)
        }
    }

    override suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel> {
        return try {
            service.getFinVizData(companyTicker).toApiResponse()
        } catch (e: HttpException) {
            ApiResponse.Error(e)
        }
    }

    override suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel> {
        return try {
            service.getShortSqueezeData(companyTicker).toApiResponse()
        } catch (e: HttpException) {
            ApiResponse.Error(e)
        }
    }

    private fun <T> Response<T>.toApiResponse(): ApiResponse<T> {
        return if (isSuccessful) {
            body()?.let {
                ApiResponse.Success(it)
            } ?: ApiResponse.Error(Exception(code().toString()))
        } else {
            errorBody()?.let {
                ApiResponse.Error(Exception(it.toString()))
            } ?: ApiResponse.Error(Exception(code().toString()))
        }
    }
}
