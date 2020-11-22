package com.assessment.nytimes.di.builder

import com.assessment.nytimes.data.repository.ArticlesRepositoryImpl
import com.assessment.nytimes.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsNyTimesArticlesRepository(articlesRepositoryImpl: ArticlesRepositoryImpl): ArticlesRepository
}