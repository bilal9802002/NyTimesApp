package com.assessment.nytimes.data.remote

import com.assessment.nytimes.constants.AppConstants
import com.assessment.nytimes.data.model.PopularArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiArticlesService {

    @GET(AppConstants.ApiPath.MOST_POPULAR_ARTICLES_VIEWED)
    suspend fun mostPopularArticles(@Path("period") period: String, @Query("api-key") apiKey: String): PopularArticlesResponse
}