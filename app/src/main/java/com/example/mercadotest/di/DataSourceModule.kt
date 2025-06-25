package com.example.mercadotest.di

import com.example.mercadotest.data.apisource.ApiDataSource
import com.example.mercadotest.data.apisource.ApiDataSourceImp
import com.example.mercadotest.data.repository.Repository
import com.example.mercadotest.data.repository.RepositoryImp
import com.example.mercadotest.data.service.MeliMockService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideApiDataSource(mockedService: MeliMockService): ApiDataSource {
        return ApiDataSourceImp(mockedService)
    }

    @Provides
    fun provideRepository(dataSource: ApiDataSource): Repository {
        return RepositoryImp(dataSource)
    }
}