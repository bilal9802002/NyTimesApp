package com.assessment.nytimes.presentation.articles

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.assessment.nytimes.data.model.Article
import com.assessment.nytimes.data.model.PopularArticlesResponse
import com.assessment.nytimes.domain.usecase.GetPopularArticlesUseCase
import com.assessment.nytimes.functional.NetworkBoundNoCacheResource
import com.assessment.nytimes.presentation.base.BaseViewModel
import com.assessment.nytimes.utils.AbsentLiveData
import com.assessment.nytimes.functional.Resource
import javax.inject.Inject

class ArticlesViewModel @Inject constructor(
    context: Application,
    getPopularArticlesUseCase: GetPopularArticlesUseCase
) : BaseViewModel(context) {

    val showLoading = ObservableField<Boolean>()

    val articleRequest = MutableLiveData<String>()
    val articlesResponse: LiveData<Resource<PopularArticlesResponse>> = Transformations
        .switchMap(articleRequest) { articleRequest ->
            if (null == articleRequest)
                AbsentLiveData.create()
            else
                object: NetworkBoundNoCacheResource<PopularArticlesResponse>(viewModelScope.coroutineContext) {
                    override suspend fun loadFromNetwork(): PopularArticlesResponse {
                        return getPopularArticlesUseCase(articleRequest)
                    }
                }.asLiveData()
        }

    val articlesList = MutableLiveData<List<Article>>()
}
