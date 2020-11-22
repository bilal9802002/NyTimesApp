package com.assessment.nytimes.di.module

import com.assessment.nytimes.constants.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class NetworkModule {

    @Singleton
    @Provides
    fun provideGithubService(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build())
            .baseUrl(AppConstants.ApiConfiguration.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}