package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import retrofit2.HttpException
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRemoteDataSource @Inject constructor(
    private val service: AggregatorService
) : RemoteDataSource<AggregatorApiModel> {

    override suspend fun getShortData(companyTicker: String): ApiResponse<AggregatorApiModel> {
        return try {
            val response = service.getShortData(companyTicker)
            return if (response.isSuccessful) {
                response.body()?.let {
                    ApiResponse.Success(it)
                } ?: ApiResponse.Error(Exception(response.code().toString()))
            } else {
                response.errorBody()?.let {
                    ApiResponse.Error(Exception(it.toString()))
                } ?: ApiResponse.Error(Exception(response.code().toString()))
            }
        } catch (e: HttpException) {
            ApiResponse.Error(e)
        }
    }
}
