package com.assessment.nytimes.data.repository

import com.assessment.nytimes.constants.AppConstants
import com.assessment.nytimes.data.remote.ApiArticlesService
import com.assessment.nytimes.domain.repository.ArticlesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesRepositoryImpl @Inject constructor(private val apiArticlesService: ApiArticlesService) :
    ArticlesRepository {
    override suspend fun mostPopularViewed(period: String) = apiArticlesService.mostPopularArticles(
        period,
        AppConstants.ApiConfiguration.API_KEY_MOST_POPULAR_ARTICLES_VIEWED
    )
}
