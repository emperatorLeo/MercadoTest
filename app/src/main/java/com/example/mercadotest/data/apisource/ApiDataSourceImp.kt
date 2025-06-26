package com.example.mercadotest.data.apisource

import android.util.Log
import com.example.mercadotest.data.model.ProductItemResponse
import com.example.mercadotest.data.service.MeliMockService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.Response.error
import retrofit2.Response.success

class ApiDataSourceImp(private val service: MeliMockService) : ApiDataSource {
    var queryCounter = 0

    override suspend fun getSearch(query: String): Flow<Response<List<ProductItemResponse>>> =
        flow {
            Log.d("Leo","counter $queryCounter")
            if (queryCounter <= 2) {
                emit(success(service.queryService(query)))
                queryCounter++
            } else {
                queryCounter = 0
                emit(getMockedErrorResponse())
            }
        }

    fun getMockedErrorResponse(): Response<List<ProductItemResponse>> {
        val httpStatusCode = 401
        val httpMessage = "Unauthorized"

        val errorBodyJson = """
                {"message":"$httpMessage"}
                """.toResponseBody("application/json".toMediaTypeOrNull())

        val errorResponse = error<List<ProductItemResponse>>(
            errorBodyJson,
            okhttp3.Response.Builder()
                .code(httpStatusCode)
                .message(httpMessage)
                .protocol(okhttp3.Protocol.HTTP_1_1)
                .request(okhttp3.Request.Builder().url("http://localhost/").build())
                .body(errorBodyJson)
                .build()
        )
        return errorResponse
    }
}