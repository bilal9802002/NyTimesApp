package com.assessment.nytimes.domain.usecase

import com.assessment.nytimes.data.model.PopularArticlesResponse

interface GetPopularArticlesUseCase {

    suspend operator fun invoke(period: String): PopularArticlesResponse
}