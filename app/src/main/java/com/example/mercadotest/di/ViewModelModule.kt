package com.example.mercadotest.di

import com.example.mercadotest.domain.usecase.SearchUseCase
import com.example.mercadotest.presentation.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideMainViewModel(searchUseCase: SearchUseCase): MainViewModel {
        return MainViewModel(searchUseCase)
    }
}