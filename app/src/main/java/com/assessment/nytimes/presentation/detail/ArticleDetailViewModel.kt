package com.assessment.nytimes.presentation.detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.assessment.nytimes.data.model.Article
import com.assessment.nytimes.presentation.base.BaseViewModel
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(context: Application): BaseViewModel(context) {
    val title = MutableLiveData<String>()
    val section = MutableLiveData<String>()
    val source = MutableLiveData<String>()
    val link = MutableLiveData<String>()

    fun updateView(article: Article) {
        title.value = article.title
        section.value = article.section
        source.value = article.source
        link.value = article.url
    }
}