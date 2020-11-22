package com.assessment.nytimes.di.builder

import com.assessment.nytimes.domain.usecase.GetPopularArticlesUseCase
import com.assessment.nytimes.domain.usecase.GetPopularArticlesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryBuilder::class])
abstract class UsecaseBuilder {
    @Binds
    abstract fun bindsGetPopularArticlesUsecase(getPopularArticlesUseCaseImpl: GetPopularArticlesUseCaseImpl): GetPopularArticlesUseCase
}