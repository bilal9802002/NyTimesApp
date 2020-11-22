package com.assessment.nytimes.domain.repository

import com.assessment.nytimes.data.model.PopularArticlesResponse

interface ArticlesRepository {
    suspend fun mostPopularViewed(period: String): PopularArticlesResponse
}