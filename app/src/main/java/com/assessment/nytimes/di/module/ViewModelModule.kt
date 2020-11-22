package com.assessment.nytimes.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assessment.nytimes.di.builder.RepositoryBuilder
import com.assessment.nytimes.di.builder.UsecaseBuilder
import com.assessment.nytimes.di.keys.ViewModelKey
import com.assessment.nytimes.presentation.main.MainViewModel
import com.assessment.nytimes.presentation.articles.ArticlesViewModel
import com.assessment.nytimes.di.vm.AppViewModelFactory
import com.assessment.nytimes.presentation.detail.ArticleDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [UsecaseBuilder::class])
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    fun bindArticlesViewModel(articlesViewModel: ArticlesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailViewModel::class)
    fun bindArticleDetailViewModel(articleDetailViewModel: ArticleDetailViewModel): ViewModel

    @Binds
    fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}