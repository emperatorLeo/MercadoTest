package com.example.mercadotest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mercadotest.domain.model.ProductDto
import com.example.mercadotest.domain.usecase.SearchUseCase
import com.example.mercadotest.presentation.viewmodel.MainViewModel
import com.example.mercadotest.presentation.viewmodel.UIState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @RelaxedMockK
    private lateinit var searchUseCase: SearchUseCase

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mainViewModel = MainViewModel(searchUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when invoke searchUseCase with a existing product, uiState should be success`() = runTest {
        // Given
        val query = "iphone"
        val mockedProductDto = ProductDto(
            0, "", "", listOf(), "", "", "", "", "", ""
        )
        val mockedList = listOf(mockedProductDto)
        val mockedFlow = flow<Response<List<ProductDto>>> { emit(Response.success(mockedList)) }
        coEvery { searchUseCase(query) } returns mockedFlow

        // WHEN
        mainViewModel.getProducts(query)

        // THEN
        assertEquals(UIState.Success(mockedList), mainViewModel.productsState.value)

    }

    @Test
    fun `when invoke searchUseCase with an unexisting product, uiState should be empty`() = runTest {
        // Given
        val query = "Pelota"
        val mockedList = listOf<ProductDto>()
        val mockedFlow = flow<Response<List<ProductDto>>> { emit(Response.success(mockedList)) }
        coEvery { searchUseCase(query) } returns mockedFlow

        // WHEN
        mainViewModel.getProducts(query)

        // THEN
        assertEquals(UIState.Empty, mainViewModel.productsState.value)

    }

    @Test
    fun `when invoke searchUseCase and there is an Error, uiState should be error`() = runTest {
        // Given
        val query = "iphone"
        val mockedFlow = flow{ emit(getMockedErrorResponse()) }
        coEvery { searchUseCase(query) } returns mockedFlow

        // WHEN
        mainViewModel.getProducts(query)

        // THEN
        assertEquals(UIState.Error("Server Error"), mainViewModel.productsState.value)

    }

    private fun getMockedErrorResponse(): Response<List<ProductDto>> {
        val httpStatusCode = 500
        val httpMessage = "Server Error"

        val errorBodyJson = """
                {"message":"$httpMessage"}
                """.toResponseBody("application/json".toMediaTypeOrNull())

        val errorResponse = Response.error<List<ProductDto>>(
            errorBodyJson,
            okhttp3.Response.Builder()
                .code(httpStatusCode)
                .message(httpMessage)
                .protocol(Protocol.HTTP_1_1)
                .request(Request.Builder().url("http://localhost/").build())
                .body(errorBodyJson)
                .build()
        )
        return errorResponse
    }
}