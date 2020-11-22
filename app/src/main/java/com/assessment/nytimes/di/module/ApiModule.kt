package com.assessment.nytimes.di.module

import com.assessment.nytimes.data.remote.ApiArticlesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun provideApiNyTimesArticlesService(retrofit: Retrofit): ApiArticlesService {
        return retrofit.create(ApiArticlesService::class.java)
    }
}