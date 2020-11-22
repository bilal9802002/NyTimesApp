package com.assessment.nytimes.presentation.articles

import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.assessment.nytimes.BR
import com.assessment.nytimes.R
import com.assessment.nytimes.data.model.Article
import com.assessment.nytimes.databinding.ArticlesFragmentBinding
import com.assessment.nytimes.presentation.base.BaseFragment
import com.assessment.nytimes.functional.Status
import com.assessment.nytimes.utils.NavigationCommand

class ArticlesFragment : BaseFragment<ArticlesFragmentBinding, ArticlesViewModel>(), ArticlesAdapter.ItemClickListener {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.articles_fragment

    override val viewModel: Class<ArticlesViewModel>
        get() = ArticlesViewModel::class.java

    override fun subscribeToViewLiveData() {
        super.subscribeToViewLiveData()

        injectedViewModel.articlesList.observe(this, Observer {
            viewDataBinding.recyclerView.adapter = ArticlesAdapter(it, this)
        })
    }

    override fun subscribeToNetworkLiveData() {
        super.subscribeToNetworkLiveData()

        injectedViewModel.articleRequest.postValue("7")

        injectedViewModel.articlesResponse.observe(this, Observer { result ->
            injectedViewModel.showLoading.set(result?.status == Status.LOADING)

            if (result?.status == Status.SUCCESS) {
                injectedViewModel.articlesList.value = result.data?.results
            } else if (result?.status == Status.ERROR) {
                AlertDialog.Builder(requireActivity())
                    .setMessage(result.message)
                    .setPositiveButton(R.string._ok, null)
                    .show()
            }
        })
    }

    override fun onClick(article: Article) {
        injectedViewModel.navigationCommands.value = NavigationCommand.To(ArticlesFragmentDirections.actionArticlesToDetails(article))
    }
}
