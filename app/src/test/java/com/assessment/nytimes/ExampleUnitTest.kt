package com.assessment.nytimes

import com.assessment.nytimes.constants.AppConstants
import com.assessment.nytimes.data.remote.ApiArticlesService
import com.assessment.nytimes.data.repository.ArticlesRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    lateinit var retrofit: Retrofit

    @Before
    fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build())
            .baseUrl(AppConstants.ApiConfiguration.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Assert.assertNotNull(retrofit)
    }

    @Test
    fun checkApiClient() {
        Assert.assertNotNull(retrofit)

        val apiService = retrofit.create(ApiArticlesService::class.java)

        Assert.assertNotNull(apiService)

        val repo = ArticlesRepositoryImpl(apiService)

        Assert.assertNotNull(repo)
    }
}
