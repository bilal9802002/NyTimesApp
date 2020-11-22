package com.assessment.nytimes.domain.usecase

import com.assessment.nytimes.data.model.PopularArticlesResponse
import com.assessment.nytimes.domain.repository.ArticlesRepository
import javax.inject.Inject

class GetPopularArticlesUseCaseImpl @Inject constructor(private val articlesRepository: ArticlesRepository): GetPopularArticlesUseCase {
    override suspend operator fun invoke(period: String): PopularArticlesResponse = articlesRepository.mostPopularViewed(period)
}