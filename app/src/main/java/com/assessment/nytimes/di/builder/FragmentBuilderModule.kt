package com.assessment.nytimes.di.builder

import com.assessment.nytimes.presentation.articles.ArticlesFragment
import com.assessment.nytimes.presentation.detail.ArticleDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeArticlesFragment(): ArticlesFragment

    @ContributesAndroidInjector
    abstract fun contributeArticleDetailFragment(): ArticleDetailFragment
}